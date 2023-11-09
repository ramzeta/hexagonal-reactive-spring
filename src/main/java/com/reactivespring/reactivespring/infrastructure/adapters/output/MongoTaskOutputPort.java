package com.reactivespring.reactivespring.infrastructure.adapters.output;



import com.reactivespring.reactivespring.application.output.TaskOutputPort;
import com.reactivespring.reactivespring.domain.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MongoTaskOutputPort implements TaskOutputPort{

    private final TaskRepository taskRepository;

    public MongoTaskOutputPort(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Mono<Task> save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Mono<Task> delete(String id) {
        return taskRepository.findById(id)
                .flatMap(task -> taskRepository.delete(task).thenReturn(task));
    }

    @Override
    public Mono<Task> update(String id, Task task) {
        return taskRepository.findById(id)
                .flatMap(task1 -> {
                    task1.setName(task.getName());
                    task1.setDescription(task.getDescription());
                    task1.setCompleted(task.isCompleted());
                    return taskRepository.save(task1);
                });
    }

    @Override
    public Mono<Task> get(String id) {
        return taskRepository.findById(id);
    }

    @Override
    public Mono<Task> getByName(String name) {
        // TODO: Implement this method contains characters 
        return taskRepository.findByName(name);
    }

    @Override
    public Flux<Task> getAll() {
        return taskRepository.findAll();
    }
    
}
