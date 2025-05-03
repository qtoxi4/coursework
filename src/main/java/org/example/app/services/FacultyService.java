package org.example.app.services;

import org.example.app.models.Faculty;
import org.example.app.repo.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepo repository;

    public FacultyService(FacultyRepo repository) {
        this.repository = repository;
    }

    public List<Faculty> findAll() {
        return repository.findAll();
    }

    public Optional<Faculty> findById(Long id) {
        return repository.findById(id);
    }

    public Faculty save(Faculty faculty) {
        return repository.save(faculty);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
