package com.example.dev2taskmanager.dto;


import com.example.dev2taskmanager.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private Long id;

    @NotBlank(message = "Le titre ne peut pas être vide.")
    @Size(max = 100, message = "Le titre ne doit pas dépasser 100 caractères.")
    @NotBlank(message = "Le titre ne peut pas être vide.")
    @Pattern(
            regexp = "^[\\p{L}0-9'\\-\\s]+$",
            message = "Le titre ne doit contenir que des lettres, chiffres, espaces, apostrophes ou traits d'union."
    )
    private String title;

    @Size(max = 500, message = "La description ne doit pas dépasser 500 caractères.")
    private String description;

    @NotNull(message = "Le statut de la tâche est obligatoire.")
    private TaskStatus status;
}
