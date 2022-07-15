package com.crytek.crysis.repository;

import java.util.List;

import com.crytek.crysis.model.Music;
import com.crytek.crysis.model.MusicFile;

import org.springframework.data.repository.CrudRepository;

public interface MusicFileRepository extends CrudRepository<MusicFile,Long> {

    List<MusicFile> findAll();

    MusicFile findById(long id);

    void deleteById(long id);

    MusicFile findByMusic(Music music);
}
