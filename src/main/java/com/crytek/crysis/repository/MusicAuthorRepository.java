package com.crytek.crysis.repository;

import com.crytek.crysis.model.Author;
import com.crytek.crysis.model.MusicAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicAuthorRepository extends CrudRepository<MusicAuthor, Long> {

    boolean existsByMusicTitleAndAuthor(String title, Author author);
}
