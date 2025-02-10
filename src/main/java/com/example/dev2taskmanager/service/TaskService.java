package com.example.dev2taskmanager.service;

import com.example.dev2taskmanager.dto.TaskDto;
import com.example.dev2taskmanager.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(TaskDto taskDto);
    Optional<Task> updateTask(Long id, TaskDto taskDto);
    Optional<Task>  getTaskById(Long id);
    List<Task> getAllTasks();
    void deleteTask(Long id);
}
