package org.example.app.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private Specialty specialty;

    @ManyToOne
    private Applicant applicant;

    @OneToMany(mappedBy = "application")
    private List<SubjectResult> subjectResults;
}
