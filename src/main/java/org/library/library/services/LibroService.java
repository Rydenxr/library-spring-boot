package org.library.library.services;

import org.library.library.dto.CrearLibroDto;
import org.library.library.dto.LibroDtoResponse;
import org.library.library.entities.Libro;
import org.library.library.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Optional<Libro> findByIsbn(String isbn) {
        return this.libroRepository.findByIsbn(isbn);
    }

    public LibroDtoResponse crearLibro(CrearLibroDto request) {
        Optional<Libro> libro = libroRepository.findByIsbn(request.isbn());
        if (libro.isPresent()) {
            throw new IllegalArgumentException("Ya existe un libro con ese ISBN");
        }

        Libro nuevoLibro = request.toEntity();
        Libro libroGuardado = libroRepository.save(nuevoLibro);

        return LibroDtoResponse.fromEntity(libroGuardado);
    }

    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
}
