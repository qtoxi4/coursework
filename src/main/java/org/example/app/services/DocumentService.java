package org.example.app.services;

import jakarta.persistence.EntityNotFoundException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.DocumentDTO;
import org.example.app.mapper.DocumentMapper;
import org.example.app.models.Applicant;
import org.example.app.models.Document;
import org.example.app.repo.ApplicantRepo;
import org.example.app.repo.DocumentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepo repository;
    private final ApplicantRepo applicantRepository;

    public DocumentDTO create(DocumentDTO dto) {
        Applicant applicant = applicantRepository.findById(dto.getApplicantId())
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found"));

        Document saved = repository.save(DocumentMapper.toEntity(dto, applicant));
        return DocumentMapper.toDto(saved);
    }

    public DocumentDTO update(Long id, DocumentDTO dto) {
        Document document = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Document not found"));

        Applicant applicant = applicantRepository.findById(dto.getApplicantId())
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found"));

        document.setDocumentNumber(dto.getDocumentNumber());
        document.setIssueDate(dto.getIssueDate());
        document.setApplicant(applicant);

        return DocumentMapper.toDto(repository.save(document));
    }

    public DocumentDTO getById(Long id) {
        return repository.findById(id)
                .map(DocumentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Document not found"));
    }

    public List<DocumentDTO> getAll() {
        return repository.findAll().stream()
                .map(DocumentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Document not found");
        }
        repository.deleteById(id);
    }
}
