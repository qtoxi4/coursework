package org.example.app.mapper;

import org.example.app.dto.SubjectDTO;
import org.example.app.models.Subject;

public class SubjectMapper {
  public static SubjectDTO toDto(Subject entity) {
    SubjectDTO dto = new SubjectDTO();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    return dto;
  }

  public static Subject toEntity(SubjectDTO dto) {
    Subject entity = new Subject();
    entity.setId(dto.getId());
    entity.setName(dto.getName());
    return entity;
  }
}
