package org.example.app.models;
import jakarta.persistence.*;

@Entity
public class SubjectResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer score;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Application application;
}

