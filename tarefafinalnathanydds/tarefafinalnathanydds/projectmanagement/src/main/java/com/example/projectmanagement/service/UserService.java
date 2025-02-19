package com.example.projectmanagement.service;

import com.example.projectmanagement.model.User;
import com.example.projectmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public Optional<User> updateUser(Long id, User user) {
        return repository.findById(id)
                .map(existing -> {
                    user.setId(id);
                    return repository.save(user);
                });
    }

    public boolean deleteUser(Long id) {
        return repository.findById(id).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
    }
}
