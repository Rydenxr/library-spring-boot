package org.library.library.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.library.library.enums.IdiomaEnum;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@RequiredArgsConstructor
public class Libro {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", unique = true, nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @ElementCollection
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    @Enumerated(EnumType.STRING)
    private Set<IdiomaEnum> idiomas = new HashSet<>();

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "disponible")
    private boolean disponible;

    @Column(name = "fecha_publicacion", nullable = true)
    private Date fechaPublicacion;
}
