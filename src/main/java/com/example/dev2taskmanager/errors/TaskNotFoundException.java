package com.example.dev2taskmanager.errors;

public class TaskNotFoundException extends TaskManagerException {
    public TaskNotFoundException( CustomErrorCode errorCode ) {
        super(errorCode);
    }
}
