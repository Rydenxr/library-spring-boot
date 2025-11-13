package org.library.library.dto;

import org.library.library.entities.Libro;
import org.library.library.enums.IdiomaEnum;

import java.util.Date;
import java.util.Set;

public record LibroDtoResponse(Long id,
                               String titulo,
                               String autor,
                               Set<IdiomaEnum>idiomas,
                               String isbn,
                               boolean disponible,
                               Date fechaPublicacion
) {
    public static LibroDtoResponse fromEntity(Libro libro) {
        return new LibroDtoResponse(
                libro.getId(),
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIdiomas(),
                libro.getIsbn(),
                libro.isDisponible(),
                libro.getFechaPublicacion()
        );
    }
}
