package org.example.app.mapper;

import org.example.app.dto.DocumentDTO;
import org.example.app.models.Applicant;
import org.example.app.models.Document;

public class DocumentMapper {
  public static Document toEntity(DocumentDTO dto, Applicant applicant) {
    Document entity = new Document();
    entity.setId(dto.getId());
    entity.setDocumentNumber(dto.getDocumentNumber());
    entity.setIssueDate(dto.getIssueDate());
    entity.setApplicant(applicant);
    return entity;
  }

  public static DocumentDTO toDto(Document entity) {
    DocumentDTO dto = new DocumentDTO();
    dto.setId(entity.getId());
    dto.setDocumentNumber(entity.getDocumentNumber());
    dto.setIssueDate(entity.getIssueDate());
    dto.setApplicantId(entity.getApplicant().getId());
    return dto;
  }
}
