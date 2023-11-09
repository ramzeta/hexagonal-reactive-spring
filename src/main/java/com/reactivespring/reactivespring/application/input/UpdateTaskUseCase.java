package com.reactivespring.reactivespring.application.input;

import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Mono;

public interface UpdateTaskUseCase {
    Mono<Task> update(String id, Task task);
}
