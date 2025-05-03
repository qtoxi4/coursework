package org.example.app.mapper;

import org.example.app.dto.ApplicationDTO;
import org.example.app.models.Applicant;
import org.example.app.models.Application;
import org.example.app.models.Specialty;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMapper {
  public static Application toEntity(ApplicationDTO dto, Applicant applicant, Specialty specialty) {
    Application entity = new Application();
    entity.setId(dto.getId());
    entity.setDate(dto.getDate());
    entity.setApplicant(applicant);
    entity.setSpecialty(specialty);
    return entity;
  }

  public static ApplicationDTO toDto(Application entity) {
    ApplicationDTO dto = new ApplicationDTO();
    dto.setId(entity.getId());
    dto.setDate(entity.getDate());
    dto.setApplicantId(entity.getApplicant().getId());
    dto.setSpecialtyId(entity.getSpecialty().getId());
    return dto;
  }
}
