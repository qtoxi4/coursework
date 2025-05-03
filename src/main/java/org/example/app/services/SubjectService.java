package org.example.app.services;

import org.example.app.models.Subject;
import org.example.app.repo.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepo repository;

    public SubjectService(SubjectRepo repository) {
        this.repository = repository;
    }

    public List<Subject> findAll() {
        return repository.findAll();
    }

    public Optional<Subject> findById(Long id) {
        return repository.findById(id);
    }

    public Subject save(Subject subject) {
        return repository.save(subject);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
