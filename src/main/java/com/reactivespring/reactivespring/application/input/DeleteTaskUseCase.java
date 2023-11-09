package com.reactivespring.reactivespring.application.input;

import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Mono;

public interface DeleteTaskUseCase {
    Mono<Task> delete(String id);
}
