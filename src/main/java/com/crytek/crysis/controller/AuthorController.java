package com.crytek.crysis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.crytek.crysis.dtos.request.AuthorRequestDTO;
import com.crytek.crysis.model.ResponseApi;
import com.crytek.crysis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crytek.crysis.model.Author;
import com.crytek.crysis.repository.AuthorRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository repository;
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAll() {
        try {
            List<Author> items = new ArrayList<Author>();

            repository.findAll().forEach(items::add);

            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable("id") Long id) {
        Optional<Author> existingItemOptional = repository.findById(id);

        if (existingItemOptional.isPresent()) {
            return new ResponseEntity<>(existingItemOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ResponseApi> create(@RequestBody AuthorRequestDTO dto) throws Exception {
        authorService.createAuthor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseApi("Autor criado com sucesso", null));
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> update(@PathVariable("id") Long id, @RequestBody Author item) {
        Optional<Author> existingItemOptional = repository.findById(id);
        if (existingItemOptional.isPresent()) {
            Author existingItem = existingItemOptional.get();
            System.out.println("TODO for developer - update logic is unique to entity and must be implemented manually.");
            //existingItem.setSomeField(item.getSomeField());
            return new ResponseEntity<>(repository.save(existingItem), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") Long id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}