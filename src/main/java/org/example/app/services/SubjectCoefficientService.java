package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.SubjectCoefficientDTO;
import org.example.app.mapper.SubjectCoefficientMapper;
import org.example.app.models.SubjectCoefficient;
import org.example.app.repo.FacultyRepo;
import org.example.app.repo.SubjectCoefficientRepo;
import org.example.app.repo.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectCoefficientService {
    private final SubjectCoefficientRepo subjectCoefficientRepository;
    private final SubjectRepo subjectRepository;
    private final FacultyRepo facultyRepository;

    public SubjectCoefficientDTO create(SubjectCoefficientDTO dto) {
        SubjectCoefficient entity = SubjectCoefficientMapper.toEntity(dto);
        entity.setSubject(subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new EntityNotFoundException("Subject not found")));
        entity.setFaculty(facultyRepository.findById(dto.getFacultyId())
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found")));
        SubjectCoefficient saved = subjectCoefficientRepository.save(entity);
        return SubjectCoefficientMapper.toDto(saved);
    }

    public SubjectCoefficientDTO update(Long id, SubjectCoefficientDTO dto) {
        SubjectCoefficient subjectCoefficient = subjectCoefficientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("SubjectCoefficient not found"));
        subjectCoefficient.setCoefficient(dto.getCoefficient());
        return SubjectCoefficientMapper.toDto(subjectCoefficientRepository.save(subjectCoefficient));
    }

    public SubjectCoefficientDTO getById(Long id) {
        return subjectCoefficientRepository.findById(id)
                .map(SubjectCoefficientMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("SubjectCoefficient not found"));
    }

    public List<SubjectCoefficientDTO> getAll() {
        return subjectCoefficientRepository.findAll().stream()
                .map(SubjectCoefficientMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!subjectCoefficientRepository.existsById(id)) {
            throw new EntityNotFoundException("SubjectCoefficient not found");
        }
        subjectCoefficientRepository.deleteById(id);
    }
}