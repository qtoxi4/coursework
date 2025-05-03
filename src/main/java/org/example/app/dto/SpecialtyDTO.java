package org.example.app.dto;

import lombok.Data;

@Data
public class SpecialtyDTO {
  private Long id;
  private String name;
  private Integer budgetSeats;
  private Long facultyId;
}
