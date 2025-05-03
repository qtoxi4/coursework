package org.example.app.services;

import org.example.app.models.SubjectResult;
import org.example.app.repo.SubjectResultRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectResultService {

    private final SubjectResultRepo repository;

    public SubjectResultService(SubjectResultRepo repository) {
        this.repository = repository;
    }

    public List<SubjectResult> findAll() {
        return repository.findAll();
    }

    public Optional<SubjectResult> findById(Long id) {
        return repository.findById(id);
    }

    public SubjectResult save(SubjectResult result) {
        return repository.save(result);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
