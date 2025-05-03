package org.example.app.services;

import org.example.app.models.SubjectCoefficient;
import org.example.app.repo.SubjectCoefficientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectCoefficientService {

    private final SubjectCoefficientRepo repository;

    public SubjectCoefficientService(SubjectCoefficientRepo repository) {
        this.repository = repository;
    }

    public List<SubjectCoefficient> findAll() {
        return repository.findAll();
    }

    public Optional<SubjectCoefficient> findById(Long id) {
        return repository.findById(id);
    }

    public SubjectCoefficient save(SubjectCoefficient coefficient) {
        return repository.save(coefficient);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
