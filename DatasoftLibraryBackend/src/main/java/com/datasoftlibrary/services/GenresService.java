package com.datasoftlibrary.services;

import com.datasoftlibrary.models.Genres;
import com.datasoftlibrary.repositories.GenresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {

    private final GenresRepository genresRepository;

    public GenresService(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    public List<Genres> getAllGenres() {
        return (List<Genres>) genresRepository.findAll();
    }
}
