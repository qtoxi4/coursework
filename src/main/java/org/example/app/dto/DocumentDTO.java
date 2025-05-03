package org.example.app.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class DocumentDTO {
  private Long id;
  private String documentNumber;
  private LocalDate issueDate;
  private Long applicantId;
}
