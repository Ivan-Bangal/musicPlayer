package com.crytek.crysis.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crytek.crysis.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
    
    Author findById(long id);

    List<Author> findAll();
    Optional<Author>findByNameContainingIgnoreCase(String name);

    boolean existsByNameAndNickName(String name, String nickName);

}
