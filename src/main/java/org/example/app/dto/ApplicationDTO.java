package org.example.app.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ApplicationDTO {
  private Long id;
  private LocalDate date;
  private Long specialtyId;
  private Long applicantId;
}
