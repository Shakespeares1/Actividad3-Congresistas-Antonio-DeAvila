package co.edu.udec.congresistas.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCongresistaRepository extends JpaRepository<CongresistaEntity, Long> {
}
