package org.example.app.mapper;

import org.example.app.dto.SpecialtyDTO;
import org.example.app.models.Specialty;

public class SpecialtyMapper {
  public static SpecialtyDTO toDto(Specialty entity) {
    SpecialtyDTO dto = new SpecialtyDTO();
    dto.setId(entity.getId());
    dto.setName(entity.getName());
    dto.setBudgetSeats(entity.getBudgetSeats());
    dto.setFacultyId(entity.getFaculty().getId());
    return dto;
  }

  public static Specialty toEntity(SpecialtyDTO dto) {
    Specialty entity = new Specialty();
    entity.setId(dto.getId());
    entity.setName(dto.getName());
    entity.setBudgetSeats(dto.getBudgetSeats());
    return entity;
  }
}
