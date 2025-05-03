package org.example.app.models;
import jakarta.persistence.*;

@Entity
public class SubjectCoefficient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double coefficient;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Faculty faculty;
}
