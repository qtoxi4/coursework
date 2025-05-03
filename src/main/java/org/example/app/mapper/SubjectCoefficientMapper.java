package org.example.app.mapper;

import org.example.app.dto.SubjectCoefficientDTO;
import org.example.app.models.SubjectCoefficient;

public class SubjectCoefficientMapper {
  public static SubjectCoefficientDTO toDto(SubjectCoefficient entity) {
    SubjectCoefficientDTO dto = new SubjectCoefficientDTO();
    dto.setId(entity.getId());
    dto.setCoefficient(entity.getCoefficient());
    dto.setSubjectId(entity.getSubject().getId());
    dto.setFacultyId(entity.getFaculty().getId());
    return dto;
  }

  public static SubjectCoefficient toEntity(SubjectCoefficientDTO dto) {
    SubjectCoefficient entity = new SubjectCoefficient();
    entity.setId(dto.getId());
    entity.setCoefficient(dto.getCoefficient());
    return entity;
  }
}
