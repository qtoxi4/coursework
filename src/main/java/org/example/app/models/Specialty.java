package org.example.app.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer budgetSeats;

    @ManyToOne
    private Faculty faculty;

    @OneToMany(mappedBy = "specialty")
    private List<Application> applications;
}
