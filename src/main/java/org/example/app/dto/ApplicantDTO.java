package org.example.app.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ApplicantDTO {
  private Long id;
  private String fullName;
  private LocalDate birthDate;
  private Double additionalScore;
}

