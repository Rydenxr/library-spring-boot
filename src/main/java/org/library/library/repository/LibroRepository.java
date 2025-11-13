package org.library.library.repository;

import org.library.library.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<Libro> findAllByIsbn(String isbn);
    Optional<Libro> findByIsbn(String isbn);
    List<Libro> findByDisponible(Boolean disponible);
}
