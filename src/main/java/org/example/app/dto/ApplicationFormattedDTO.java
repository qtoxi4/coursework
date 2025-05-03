package org.example.app.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ApplicationFormattedDTO {
  private Long id;
  private String formattedDate;
  private Long specialtyId;
  private Long applicantId;
}
