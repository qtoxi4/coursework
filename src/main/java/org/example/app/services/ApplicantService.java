package org.example.app.services;
import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.ApplicantDTO;
import org.example.app.mapper.ApplicantMapper;
import org.example.app.models.Applicant;
import org.example.app.repo.ApplicantRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ApplicantService {

    private final ApplicantRepo applicantRepository;
    private final ApplicantMapper applicantMapper;

    public List<ApplicantDTO> getAll() {
        return applicantRepository.findAll()
                .stream()
                .map(applicantMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ApplicantDTO getById(Long id) {
        return applicantRepository.findById(id)
                .map(applicantMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found"));
    }

    public void create(ApplicantDTO dto) {
        applicantRepository.save(applicantMapper.toEntity(dto));
    }

    public void update(Long id, ApplicantDTO dto) {
        Applicant existing = applicantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found"));
        existing.setFullName(dto.getFullName());
        existing.setBirthDate(dto.getBirthDate());
        existing.setAdditionalScore(dto.getAdditionalScore());
        applicantRepository.save(existing);
    }

    public void delete(Long id) {
        applicantRepository.deleteById(id);
    }
}
