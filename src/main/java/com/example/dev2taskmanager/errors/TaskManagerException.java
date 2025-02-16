package com.example.dev2taskmanager.errors;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class TaskManagerException extends RuntimeException {
    private CustomErrorCode error;
    private final String message;
    private final Timestamp timestamp;

    public TaskManagerException(CustomErrorCode error){
        super(error.getCode()+" : "+error.getLabel());
        this.message = error.getCode()+" : "+error.getLabel();
        this.error = error;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public TaskManagerException(String message){
        super(message);
        this.message = message;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

}
