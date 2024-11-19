package com.exo1.exo1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "projet_task_count")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetTaskCount {
    @Id
    private Long projetId;

    private String projetName;

    private Long taskCount;
}
