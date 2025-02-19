package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Task;
import com.example.projectmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public Optional<Task> updateTask(Long id, Task task) {
        return repository.findById(id)
                .map(existing -> {
                    task.setId(id);
                    return repository.save(task);
                });
    }

    public boolean deleteTask(Long id) {
        return repository.findById(id).map(task -> {
            repository.delete(task);
            return true;
        }).orElse(false);
    }
}
