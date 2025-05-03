package org.example.app.mapper;

import org.example.app.dto.SubjectResultDTO;
import org.example.app.models.SubjectResult;

public class SubjectResultMapper {
  public static SubjectResultDTO toDto(SubjectResult entity) {
    SubjectResultDTO dto = new SubjectResultDTO();
    dto.setId(entity.getId());
    dto.setScore(entity.getScore());
    dto.setSubjectId(entity.getSubject().getId());
    dto.setApplicationId(entity.getApplication().getId());
    return dto;
  }

  public static SubjectResult toEntity(SubjectResultDTO dto) {
    SubjectResult entity = new SubjectResult();
    entity.setId(dto.getId());
    entity.setScore(dto.getScore());
    return entity;
  }
}
