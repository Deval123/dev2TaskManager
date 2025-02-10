package com.example.dev2taskmanager.service;

import com.example.dev2taskmanager.dto.TaskDto;
import com.example.dev2taskmanager.model.Task;
import com.example.dev2taskmanager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(TaskDto taskDto) {
        var task = Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .status(taskDto.getStatus())
                .build();
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task>  updateTask(Long id, TaskDto taskDto) {
        return taskRepository.findById(id).map(
                task1 -> {
                    task1.setTitle(taskDto.getTitle());
                    task1.setDescription(taskDto.getDescription());
                    task1.setStatus(taskDto.getStatus());
                    return taskRepository.save(task1);
                }
        );
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
        taskRepository.deleteById(id);
    }
}
