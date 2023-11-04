package com.crytek.crysis.service;

import com.crytek.crysis.dtos.request.MusicStoreDTO;
import com.crytek.crysis.exceptions.NotFoundException;
import com.crytek.crysis.model.Author;
import com.crytek.crysis.model.Genre;
import com.crytek.crysis.model.Music;
import com.crytek.crysis.model.MusicAuthor;
import com.crytek.crysis.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private MusicAuthorService musicAuthorService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    public Music create(Music music) {
        return musicRepository.save(music);
    }

    public Music findById(Long id) throws NotFoundException {
        return musicRepository.findById(id).orElseThrow(()->new NotFoundException("A musica com  o id " + id + "Nao foi encontrada"));
    }

    public Music createMusic(MusicStoreDTO dto) throws NotFoundException {
        //criar a musica

        Genre genre = genreService.findById(dto.genre());
        Music newMusic = new Music(genre, dto);
        create(newMusic);
        for (Iterator<String> names = dto.names().iterator(); names.hasNext(); ) {
            Author author = authorService.findByName(names.next());
            MusicAuthor newMusicAuthor = new MusicAuthor(newMusic, author);
            musicAuthorService.create(newMusicAuthor);
        }
        return newMusic;
    }
}
