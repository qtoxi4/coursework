package org.example.app.services;

import org.example.app.models.Document;
import org.example.app.repo.DocumentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepo repository;

    public DocumentService(DocumentRepo repository) {
        this.repository = repository;
    }

    public List<Document> findAll() {
        return repository.findAll();
    }

    public Optional<Document> findById(Long id) {
        return repository.findById(id);
    }

    public Document save(Document document) {
        return repository.save(document);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
