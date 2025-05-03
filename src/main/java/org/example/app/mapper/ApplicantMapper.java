package org.example.app.mapper;

import org.example.app.dto.ApplicantDTO;
import org.example.app.models.Applicant;
import org.springframework.stereotype.Component;

@Component
public class ApplicantMapper {

  public Applicant toEntity(ApplicantDTO dto) {
    Applicant applicant = new Applicant();
    applicant.setId(dto.getId());
    applicant.setFullName(dto.getFullName());
    applicant.setBirthDate(dto.getBirthDate());
    applicant.setAdditionalScore(dto.getAdditionalScore());
    return applicant;
  }

  public ApplicantDTO toDTO(Applicant entity) {
    ApplicantDTO dto = new ApplicantDTO();
    dto.setId(entity.getId());
    dto.setFullName(entity.getFullName());
    dto.setBirthDate(entity.getBirthDate());
    dto.setAdditionalScore(entity.getAdditionalScore());
    return dto;
  }
}
