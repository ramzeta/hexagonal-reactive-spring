package com.reactivespring.reactivespring.application.input;

import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetTaskUseCase {
    Mono<Task> get(String id);
    Flux<Task> getAll();
}
