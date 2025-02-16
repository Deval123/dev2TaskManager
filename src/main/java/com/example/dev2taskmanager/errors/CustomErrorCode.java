package com.example.dev2taskmanager.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum  CustomErrorCode {
    DATA_ERROR_TASK_NOT_FOUND("404-001", "Task not found."),
    DATA_ERROR_TASK_ALREADY_EXIST("409-001", "Task title is in use");


    private final String code;
    private final String label;
}
