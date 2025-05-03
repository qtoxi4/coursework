package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.ApplicationDTO;
import org.example.app.mapper.ApplicationMapper;
import org.example.app.models.Applicant;
import org.example.app.models.Application;
import org.example.app.models.Specialty;
import org.example.app.repo.ApplicantRepo;
import org.example.app.repo.ApplicationRepo;
import org.example.app.repo.SpecialtyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepo repository;
    private final ApplicantRepo applicantRepository;
    private final SpecialtyRepo specialtyRepository;

    public ApplicationDTO create(ApplicationDTO dto) {
        Applicant applicant = applicantRepository.findById(dto.getApplicantId())
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found"));

        Specialty specialty = specialtyRepository.findById(dto.getSpecialtyId())
                .orElseThrow(() -> new EntityNotFoundException("Specialty not found"));

        Application saved = repository.save(ApplicationMapper.toEntity(dto, applicant, specialty));
        return ApplicationMapper.toDto(saved);
    }

    public ApplicationDTO update(Long id, ApplicationDTO dto) {
        Application application = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application not found"));

        Applicant applicant = applicantRepository.findById(dto.getApplicantId())
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found"));

        Specialty specialty = specialtyRepository.findById(dto.getSpecialtyId())
                .orElseThrow(() -> new EntityNotFoundException("Specialty not found"));

        application.setDate(dto.getDate());
        application.setApplicant(applicant);
        application.setSpecialty(specialty);

        return ApplicationMapper.toDto(repository.save(application));
    }

    public ApplicationDTO getById(Long id) {
        return repository.findById(id)
                .map(ApplicationMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Application not found"));
    }

    public List<ApplicationDTO> getAll() {
        return repository.findAll().stream()
                .map(ApplicationMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Application not found");
        }
        repository.deleteById(id);
    }
}
