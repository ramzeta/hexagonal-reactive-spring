package com.reactivespring.reactivespring.domain.service;

import org.springframework.stereotype.Service;

import com.reactivespring.reactivespring.application.input.CreateTaskUseCase;
import com.reactivespring.reactivespring.application.input.DeleteTaskUseCase;
import com.reactivespring.reactivespring.application.input.GetTaskUseCase;
import com.reactivespring.reactivespring.application.input.UpdateTaskUseCase;
import com.reactivespring.reactivespring.application.output.TaskOutputPort;
import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService implements CreateTaskUseCase, GetTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase{

    private final TaskOutputPort taskOutputPort;

    public TaskService(TaskOutputPort taskOutputPort) {
        this.taskOutputPort = taskOutputPort;
    }

    @Override
    public Mono<Task> delete(String id) {
        return taskOutputPort.delete(id);
    }

    @Override
    public Mono<Task> update(String id, Task task) {
        return taskOutputPort.update(id, task);
    }

    @Override
    public Mono<Task> get(String id) {
        return taskOutputPort.get(id);
    }

    @Override
    public Flux<Task> getAll() {
        return taskOutputPort.getAll();
    }

    @Override
    public Mono<Task> save(Task task) {
        return taskOutputPort.save(task);
    }
    
    

}
