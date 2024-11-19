package com.exo1.exo1.repository;

import com.exo1.exo1.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT DISTINCT t FROM Task t " +
            "LEFT JOIN FETCH t.projet " +
            "LEFT JOIN FETCH t.user")
    List<Task> findAllWithProjetAndUser();

    @Query("SELECT t FROM Task t " +
            "LEFT JOIN FETCH t.projet " +
            "LEFT JOIN FETCH t.user " +
            "WHERE t.id = :id")
    Optional<Task> findByIdWithProjetAndUser(@Param("id") Long id);
}
