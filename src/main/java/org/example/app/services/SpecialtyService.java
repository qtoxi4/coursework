package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.SpecialtyDTO;
import org.example.app.mapper.SpecialtyMapper;
import org.example.app.models.Specialty;
import org.example.app.repo.FacultyRepo;
import org.example.app.repo.SpecialtyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepo specialtyRepository;
    private final FacultyRepo facultyRepository;

    public SpecialtyDTO create(SpecialtyDTO dto) {
        Specialty entity = SpecialtyMapper.toEntity(dto);
        entity.setFaculty(facultyRepository.findById(dto.getFacultyId())
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found")));
        Specialty saved = specialtyRepository.save(entity);
        return SpecialtyMapper.toDto(saved);
    }

    public SpecialtyDTO update(Long id, SpecialtyDTO dto) {
        Specialty specialty = specialtyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Specialty not found"));

        specialty.setName(dto.getName());
        specialty.setBudgetSeats(dto.getBudgetSeats());
        specialty.setFaculty(facultyRepository.findById(dto.getFacultyId())
                .orElseThrow(() -> new EntityNotFoundException("Faculty not found")));
        return SpecialtyMapper.toDto(specialtyRepository.save(specialty));
    }

    public SpecialtyDTO getById(Long id) {
        return specialtyRepository.findById(id)
                .map(SpecialtyMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Specialty not found"));
    }

    public List<SpecialtyDTO> getAll() {
        return specialtyRepository.findAll().stream()
                .map(SpecialtyMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!specialtyRepository.existsById(id)) {
            throw new EntityNotFoundException("Specialty not found");
        }
        specialtyRepository.deleteById(id);
    }
}
