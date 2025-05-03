package org.example.app.services;
import org.example.app.models.Applicant;
import org.example.app.repo.ApplicantRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private final ApplicantRepo repository;

    public ApplicantService(ApplicantRepo repository) {
        this.repository = repository;
    }

    public List<Applicant> findAll() {
        return repository.findAll();
    }

    public Optional<Applicant> findById(Long id) {
        return repository.findById(id);
    }

    public Applicant save(Applicant applicant) {
        return repository.save(applicant);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}