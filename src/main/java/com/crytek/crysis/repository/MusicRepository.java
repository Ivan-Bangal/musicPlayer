package com.crytek.crysis.repository;

import java.util.List;

import com.crytek.crysis.model.Music;

import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Long>{

    List<Music> findByTitulo(String titulo);

    List<Music> findAll();


    void deleteById(long id);
} 
    

