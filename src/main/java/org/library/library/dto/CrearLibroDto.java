package org.library.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.library.library.entities.Libro;
import org.library.library.enums.IdiomaEnum;

import java.util.Date;
import java.util.Set;

public record CrearLibroDto(
        @NotBlank(message = "El título es obligatorio") String titulo,
        @NotBlank(message = "El autor es obligatorio") String autor,
        String isbn,
        @NotEmpty(message = "Debe tener al menos un idioma") Set<IdiomaEnum> idiomas,
        boolean disponible,
        Date fechaPublicacion
) {
        public Libro toEntity() {
                Libro libro = new Libro();
                libro.setTitulo(this.titulo);
                libro.setAutor(this.autor);
                libro.setIsbn(this.isbn);
                libro.setIdiomas(idiomas);
                libro.setDisponible(disponible);
                libro.setFechaPublicacion(this.fechaPublicacion);
                return libro;
        }
}
