package com.crytek.crysis.service;

import com.crytek.crysis.exceptions.NotFoundException;
import com.crytek.crysis.model.Genre;
import com.crytek.crysis.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre findById(Long id) throws NotFoundException {
        return genreRepository.findById(id).orElseThrow(()->new NotFoundException("O genero com o id " +id + "Nao foi encontrado"));
    }
}
