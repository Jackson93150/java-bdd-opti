package com.exo1.exo1.service;

import com.exo1.exo1.entity.ProjetTaskCount;
import com.exo1.exo1.mapper.ProjetTaskCountMapper;
import com.exo1.exo1.repository.ProjetTaskCountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetTaskCountService {
    private ProjetTaskCountRepository projetTaskCountRepository;
    private ProjetTaskCountMapper projetTaskCountMapper;

    public Page<ProjetTaskCount> findAllWithTaskCount(Pageable pageable) {
        return projetTaskCountRepository.findAll(pageable);
    }
}
