package com.crytek.crysis.service;

import com.crytek.crysis.dtos.request.AuthorRequestDTO;
import com.crytek.crysis.dtos.response.AuthorResponseDTO;
import com.crytek.crysis.exceptions.ConflictException;
import com.crytek.crysis.exceptions.NotFoundException;
import com.crytek.crysis.model.Author;
import com.crytek.crysis.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository  authorRepository;

    public Author create(Author author){
        return authorRepository.save(author);
    }
    public boolean existsByNameAndnNickName(String name, String nickName){
        return authorRepository.existsByNameAndNickName(name, nickName);
    }
    public Author createAuthor(AuthorRequestDTO dto) throws Exception {
        try {
            boolean authorExists = existsByNameAndnNickName(dto.name(), dto.nickName());
            if (authorExists) {
                throw new ConflictException("Autor com esse nome e nickname ja existe");
            }
            Author newAuthor = new Author(dto);
            create(newAuthor);
            return newAuthor;
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }
    public Author findById(Long id) throws NotFoundException {
        return authorRepository.findById(id).orElseThrow(()->new NotFoundException("Autor nao foi enccontrado "));
    }
    public AuthorResponseDTO findByIdResponse(Long id) throws NotFoundException {
        Author author= authorRepository.findById(id).orElseThrow(()->new NotFoundException("Autor nao foi enccontrado "));
        return  new AuthorResponseDTO(author.getId(), author.getName(), author.getAdress(), author.getNickName());
    }
    public List<AuthorResponseDTO>findAll(){
        return authorRepository.findAll().stream().map(author -> new AuthorResponseDTO(author.getId(), author.getName(), author.getAdress(), author.getNickName())).collect(Collectors.toList());
    }
    public Author findByName(String name) throws NotFoundException {
       return authorRepository.findByNameContainingIgnoreCase(name).orElseThrow(()->new NotFoundException("Autor nao foi enccontrado "));
    }

}
