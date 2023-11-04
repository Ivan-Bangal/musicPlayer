package com.crytek.crysis.db;

import com.crytek.crysis.model.Genre;
import com.crytek.crysis.service.GenreService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataBaseInitializer implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private GenreService genreService;

    @Override
    public void run(String... args) throws Exception {
        if (genreService.listAll().isEmpty()) {
            genreService.create(new Genre("Hiphop"));
            genreService.create(new Genre("Marabenta"));
        }
    }

}


