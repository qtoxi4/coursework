package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.SubjectDTO;
import org.example.app.mapper.SubjectMapper;
import org.example.app.models.Subject;
import org.example.app.repo.SubjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepo subjectRepository;

    public SubjectDTO create(SubjectDTO dto) {
        Subject entity = SubjectMapper.toEntity(dto);
        Subject saved = subjectRepository.save(entity);
        return SubjectMapper.toDto(saved);
    }

    public SubjectDTO update(Long id, SubjectDTO dto) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));
        subject.setName(dto.getName());
        return SubjectMapper.toDto(subjectRepository.save(subject));
    }

    public SubjectDTO getById(Long id) {
        return subjectRepository.findById(id)
                .map(SubjectMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Subject not found"));
    }

    public List<SubjectDTO> getAll() {
        return subjectRepository.findAll().stream()
                .map(SubjectMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new EntityNotFoundException("Subject not found");
        }
        subjectRepository.deleteById(id);
    }
}
