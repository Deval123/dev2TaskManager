package com.example.dev2taskmanager.dto;

import com.example.dev2taskmanager.model.TaskStatus;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTaskDto {

    private Long id;

    @Size(max = 100, message = "Le titre ne doit pas dépasser 100 caractères.")
    @Pattern(
            regexp = "^[\\p{L}0-9'\\-\\s]+$",
            message = "Le titre ne doit contenir que des lettres, chiffres, espaces, apostrophes ou traits d'union."
    )
    private String title;

    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères.")
    private String description;

    private TaskStatus status;
}
