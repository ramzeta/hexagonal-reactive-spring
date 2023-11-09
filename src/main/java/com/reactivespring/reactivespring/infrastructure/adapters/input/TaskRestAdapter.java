package com.reactivespring.reactivespring.infrastructure.adapters.input;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactivespring.reactivespring.application.input.CreateTaskUseCase;
import com.reactivespring.reactivespring.application.input.DeleteTaskUseCase;
import com.reactivespring.reactivespring.application.input.GetTaskUseCase;
import com.reactivespring.reactivespring.application.input.UpdateTaskUseCase;
import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TaskRestAdapter {
    
    private final CreateTaskUseCase createTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetTaskUseCase getTaskUseCase;

    public TaskRestAdapter(CreateTaskUseCase createTaskUseCase, UpdateTaskUseCase updateTaskUseCase,
            DeleteTaskUseCase deleteTaskUseCase, GetTaskUseCase getTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getTaskUseCase = getTaskUseCase;
    }

    @PostMapping("/tasks")
    public Mono<Task> save(@RequestBody Task task) {
        return createTaskUseCase.save(task);    
    }

    @PostMapping("/tasks/{id}")
    public Mono<Task> update(@RequestBody Task task) {
        return updateTaskUseCase.update(task.getId(), task);
    }

    @PostMapping("/tasks/{id}")
    public Mono<Task> delete(@RequestBody Task task) {
        return deleteTaskUseCase.delete(task.getId());
    }

    @GetMapping("/tasks/{id}")
    public Mono<Task> get(@RequestBody Task task) {
        return getTaskUseCase.get(task.getId());
    }

    @GetMapping("/tasks")
    public Flux<Task> getAll() {
        return getTaskUseCase.getAll();
    }



}
