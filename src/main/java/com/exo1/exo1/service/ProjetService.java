package com.exo1.exo1.service;

import com.exo1.exo1.dto.ProjetDto;
import com.exo1.exo1.entity.Projet;
import com.exo1.exo1.mapper.ProjetMapper;
import com.exo1.exo1.repository.ProjetRepository;
import com.exo1.exo1.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetService {
    private ProjetRepository projetRepository;
    private ProjetMapper projetMapper;
    private TaskRepository taskRepository;

    public Page<ProjetDto> findAll(Pageable pageable) {
        Page<Projet> projets = projetRepository.findAllWithUsersAndTasks(pageable);
        return projets.map(projetMapper::toDto);
    }

    public ProjetDto findById(long id) {
        return projetMapper.toDto(projetRepository.findByIdWithUsersAndTasks(id).orElse(null));
    }

    public ProjetDto save(ProjetDto projetDto) {
        Projet projet = projetMapper.toEntity(projetDto);
        projet.getTasks().stream().forEach(t -> t.setProjet(projet));
        return projetMapper.toDto(projetRepository.save(projet));
    }

    public ProjetDto update(Long id, ProjetDto projetDto) {
        Projet existingProjet = projetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Projet not found with id " + id));
        projetDto.setId(existingProjet.getId());
        Projet projetUpdated = projetMapper.toEntity(projetDto);
        projetUpdated.getTasks().stream().forEach(t -> {
            if(taskRepository.existsById(t.getId())) {
                t.setProjet(projetUpdated);
            }
        });
        return projetMapper.toDto(projetRepository.save(projetUpdated));
    }

    public void delete(Long id) {
        projetRepository.deleteById(id);
    }
}
