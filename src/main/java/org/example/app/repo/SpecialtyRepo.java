package org.example.app.repo;

import org.example.app.models.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepo extends JpaRepository<Specialty, Long> {
}
