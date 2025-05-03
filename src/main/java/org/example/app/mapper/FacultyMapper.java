package org.example.app.mapper;

import org.example.app.dto.FacultyDTO;
import org.example.app.models.Faculty;

public class FacultyMapper {
  public static FacultyDTO toDto(Faculty entity) {
    FacultyDTO dto = new FacultyDTO();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    return dto;
  }

  public static Faculty toEntity(FacultyDTO dto) {
    Faculty entity = new Faculty();
    entity.setId(dto.getId());
    entity.setName(dto.getName());
    return entity;
  }
}
