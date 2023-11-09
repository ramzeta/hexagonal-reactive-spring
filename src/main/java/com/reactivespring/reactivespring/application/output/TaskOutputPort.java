package com.reactivespring.reactivespring.application.output;

import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskOutputPort {
    Mono<Task> save(Task task);
    Mono<Task> delete(String id);
    Mono<Task> update(String id, Task task);
    Mono<Task> get(String id);
    Mono<Task> getByName(String name);
    Flux<Task> getAll();
}
