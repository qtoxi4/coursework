package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.SubjectResultDTO;
import org.example.app.mapper.SubjectResultMapper;
import org.example.app.models.SubjectResult;
import org.example.app.repo.ApplicationRepo;
import org.example.app.repo.SubjectRepo;
import org.example.app.repo.SubjectResultRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectResultService {
    private final SubjectResultRepo subjectResultRepository;
    private final SubjectRepo subjectRepository;
    private final ApplicationRepo applicationRepository;

    public SubjectResultDTO create(SubjectResultDTO dto) {
        SubjectResult entity = SubjectResultMapper.toEntity(dto);
        entity.setSubject(subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found")));
        entity.setApplication(applicationRepository.findById(dto.getApplicationId())
                .orElseThrow(() -> new EntityNotFoundException("Application not found")));
        SubjectResult saved = subjectResultRepository.save(entity);
        return SubjectResultMapper.toDto(saved);
    }

    public SubjectResultDTO update(Long id, SubjectResultDTO dto) {
        SubjectResult subjectResult = subjectResultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SubjectResult not found"));
        subjectResult.setScore(dto.getScore());
        return SubjectResultMapper.toDto(subjectResultRepository.save(subjectResult));
    }

    public SubjectResultDTO getById(Long id) {
        return subjectResultRepository.findById(id)
                .map(SubjectResultMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("SubjectResult not found"));
    }

    public List<SubjectResultDTO> getAll() {
        return subjectResultRepository.findAll().stream()
                .map(SubjectResultMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!subjectResultRepository.existsById(id)) {
            throw new EntityNotFoundException("SubjectResult not found");
        }
        subjectResultRepository.deleteById(id);
    }
}