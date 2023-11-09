package com.reactivespring.reactivespring.infrastructure.adapters.output;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Mono;

@Repository
public interface TaskRepository extends ReactiveMongoRepository<Task, String>{
    
    //find by name 
    Mono<Task> findByName(String name);
}
