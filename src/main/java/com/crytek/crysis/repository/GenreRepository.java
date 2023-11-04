package com.crytek.crysis.repository;

import com.crytek.crysis.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository  extends JpaRepository<Genre, Long> {
    boolean existsById(Long id);
}
