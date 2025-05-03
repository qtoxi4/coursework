package org.example.app.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "subject")
    private List<SubjectResult> results;

    @OneToMany(mappedBy = "subject")
    private List<SubjectCoefficient> coefficients;
}
