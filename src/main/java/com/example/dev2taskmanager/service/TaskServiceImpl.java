package com.example.dev2taskmanager.service;

import com.example.dev2taskmanager.dto.TaskDto;
import com.example.dev2taskmanager.dto.UpdateTaskDto;
import com.example.dev2taskmanager.errors.TaskManagerException;
import com.example.dev2taskmanager.errors.TaskNotFoundException;
import com.example.dev2taskmanager.model.Task;
import com.example.dev2taskmanager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.dev2taskmanager.errors.CustomErrorCode.DATA_ERROR_TASK_ALREADY_EXIST;
import static com.example.dev2taskmanager.errors.CustomErrorCode.DATA_ERROR_TASK_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task createTask(TaskDto taskDto) {
        if (taskRepository.findByTitle(taskDto.getTitle()).isPresent()) {
            throw new TaskManagerException( DATA_ERROR_TASK_ALREADY_EXIST);
        }

        var task = Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .build();

        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, UpdateTaskDto taskDto) {
        return taskRepository.findById(id)
                .map(task -> {
                    Optional.ofNullable(taskDto.getTitle()).ifPresent(task::setTitle);
                    Optional.ofNullable(taskDto.getDescription()).ifPresent(task::setDescription);
                    Optional.ofNullable(taskDto.getStatus()).ifPresent(task::setStatus);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new TaskNotFoundException(DATA_ERROR_TASK_NOT_FOUND));
    }

    @Override
    public Optional<Task>  getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new TaskNotFoundException(DATA_ERROR_TASK_NOT_FOUND);
        task.ifPresent(taskRepository::delete);
    }
}
