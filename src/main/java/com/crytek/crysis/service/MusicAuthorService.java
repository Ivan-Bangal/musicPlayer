package com.crytek.crysis.service;

import com.crytek.crysis.model.Author;
import com.crytek.crysis.model.MusicAuthor;
import com.crytek.crysis.repository.MusicAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicAuthorService {

    @Autowired
    private MusicAuthorRepository musicAuthorRepository;

    public boolean existsByTitleAndAuthor(String title, Author author){
        return musicAuthorRepository.existsByMusicTitleAndAuthor(title, author);
    }
    public MusicAuthor create(MusicAuthor musicAuthor){
        return musicAuthorRepository.save(musicAuthor);
    }
}
