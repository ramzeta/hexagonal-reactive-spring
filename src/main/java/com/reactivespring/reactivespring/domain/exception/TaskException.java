package com.reactivespring.reactivespring.domain.exception;

public class TaskException extends RuntimeException{
    
    public TaskException(String message){
        super(message);
    }

    public TaskException(String message, Throwable cause){
        super(message, cause);
    }
}
