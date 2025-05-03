package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.FacultyDTO;
import org.example.app.mapper.FacultyMapper;
import org.example.app.models.Faculty;
import org.example.app.repo.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FacultyService {
    private final FacultyRepo repository;

    public FacultyDTO create(FacultyDTO dto) {
        Faculty saved = repository.save(FacultyMapper.toEntity(dto));
        return FacultyMapper.toDto(saved);
    }

    public FacultyDTO update(Long id, FacultyDTO dto) {
        Faculty faculty = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found"));

        faculty.setName(dto.getName());
        return FacultyMapper.toDto(repository.save(faculty));
    }

    public FacultyDTO getById(Long id) {
        return repository.findById(id)
                .map(FacultyMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found"));
    }

    public List<FacultyDTO> getAll() {
        return repository.findAll().stream()
                .map(FacultyMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Faculty not found");
        }
        repository.deleteById(id);
    }
}