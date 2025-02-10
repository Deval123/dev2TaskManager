package com.example.dev2taskmanager.dto;


import com.example.dev2taskmanager.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private Long id;

    @NotBlank(message = "Le titre ne peut pas être null;")
    private String title;

    private String description;
    private TaskStatus status;
}
