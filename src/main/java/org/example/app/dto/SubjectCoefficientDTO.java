package org.example.app.dto;

import lombok.Data;

@Data
public class SubjectCoefficientDTO {
  private Long id;
  private Double coefficient;
  private Long subjectId;
  private Long facultyId;
}
