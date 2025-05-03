package org.example.app.models;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentNumber;

    private LocalDate issueDate;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}

