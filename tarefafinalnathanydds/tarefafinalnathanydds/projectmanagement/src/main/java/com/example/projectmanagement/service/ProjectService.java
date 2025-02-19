package com.example.projectmanagement.service;

import com.example.projectmanagement.model.Project;
import com.example.projectmanagement.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> getAllProjects() {
        return repository.findAll();
    }

    public Optional<Project> getProjectById(Long id) {
        return repository.findById(id);
    }

    public Project createProject(Project project) {
        return repository.save(project);
    }

    public Optional<Project> updateProject(Long id, Project project) {
        return repository.findById(id)
                .map(existing -> {
                    project.setId(id);
                    return repository.save(project);
                });
    }

    public boolean deleteProject(Long id) {
        return repository.findById(id).map(project -> {
            repository.delete(project);
            return true;
        }).orElse(false);
    }
}
