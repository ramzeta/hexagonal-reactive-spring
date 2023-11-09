package com.reactivespring.reactivespring.domain.model;

import java.util.Date;

import lombok.Data;


@Data
public class Task {
    private String id;
    private String name;
    private String description;
    private boolean completed;
    private Date createdAt;
    private Date updatedAt;

    public void updateFrom(Task task) {
        this.name = task.name;
        this.description = task.description;
        this.completed = task.completed;
        this.updatedAt = new Date();
    }
}
