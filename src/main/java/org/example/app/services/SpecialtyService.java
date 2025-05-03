package org.example.app.services;

import org.example.app.models.Specialty;
import org.example.app.repo.SpecialtyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    private final SpecialtyRepo repository;

    public SpecialtyService(SpecialtyRepo repository) {
        this.repository = repository;
    }

    public List<Specialty> findAll() {
        return repository.findAll();
    }

    public Optional<Specialty> findById(Long id) {
        return repository.findById(id);
    }

    public Specialty save(Specialty specialty) {
        return repository.save(specialty);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
