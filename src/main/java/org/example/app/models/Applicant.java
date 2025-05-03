package org.example.app.models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Applicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private LocalDate birthDate;

    private Double additionalScore;

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;

    @OneToOne(mappedBy = "applicant", cascade = CascadeType.ALL)
    private Document document;
}
