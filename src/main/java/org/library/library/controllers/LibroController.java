package org.library.library.controllers;

import jakarta.validation.Valid;
import org.library.library.dto.ApiResponse;
import org.library.library.dto.CrearLibroDto;
import org.library.library.dto.LibroDtoResponse;
import org.library.library.entities.Libro;
import org.library.library.services.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/v1/libros")
public class LibroController {
    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LibroDtoResponse>> crearLibro(@Valid @RequestBody CrearLibroDto request) {
        LibroDtoResponse response = libroService.crearLibro(request);
        ApiResponse<LibroDtoResponse> apiResponse =
                ApiResponse.success(HttpStatus.CREATED.value(), true, "Libro creado exitosamente", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping
    public ResponseEntity<?> findAllLibros() {
        List<Libro> response = libroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
