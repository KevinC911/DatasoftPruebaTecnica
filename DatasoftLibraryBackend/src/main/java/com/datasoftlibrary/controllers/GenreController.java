package com.datasoftlibrary.controllers;

import com.datasoftlibrary.repositories.GenresRepository;
import org.apache.coyote.Response;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenresRepository genresRepository;

    public GenreController(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllGenres() {
        return ResponseEntity.ok(genresRepository.findAll());
    }
}
