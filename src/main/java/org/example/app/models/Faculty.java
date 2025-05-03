package org.example.app.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "faculty")
    private List<SubjectCoefficient> coefficients;

    @OneToMany(mappedBy = "faculty")
    private List<Specialty> specialties;
}
