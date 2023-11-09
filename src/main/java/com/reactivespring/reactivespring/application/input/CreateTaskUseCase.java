package com.reactivespring.reactivespring.application.input;


import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Mono;

public interface CreateTaskUseCase {
    Mono<Task> save(Task task);
}
