package org.example.app.services;

import org.example.app.models.Application;
import org.example.app.repo.ApplicationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    private final ApplicationRepo repository;

    public ApplicationService(ApplicationRepo repository) {
        this.repository = repository;
    }

    public List<Application> findAll() {
        return repository.findAll();
    }

    public Optional<Application> findById(Long id) {
        return repository.findById(id);
    }

    public Application save(Application application) {
        return repository.save(application);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

