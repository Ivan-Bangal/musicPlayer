package com.crytek.crysis.controller;

import java.util.List;

import com.crytek.crysis.service.MusicStorageService;
import com.crytek.crysis.model.Music;
import com.crytek.crysis.repository.MusicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ApiController{

    @Autowired
    private MusicStorageService service;

    @GetMapping("/uploads/{autor}/{title}")
    public byte[] loadFile(@PathVariable String autor, @PathVariable String title){
        try{
            return service.recover(title, autor);
        }catch(Exception exception){
            return null;
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/musics")
    public List<Music> getAllMusic(){
        MusicRepository repo = service.getRepo();
        return repo.findAll();
    }

   /*  @CrossOrigin(origins = "*")
    @GetMapping("/musics/{autor}")
    public List<Music> getAuthorMusics(@PathVariable String autor){
        MusicRepository repo = service.getRepo();
        return repo.findByAutor(autor);
    } */

    @CrossOrigin(origins = "*")
    @PostMapping("/musics/insertMusic")
    public String insertMusic(Music music,MultipartFile mp3){
        service.storeFile(mp3, music);
        return "SUCESS";
    }
    

}