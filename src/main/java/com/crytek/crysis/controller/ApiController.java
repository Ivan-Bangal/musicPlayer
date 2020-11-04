package com.crytek.crysis.controller;

import com.crytek.crysis.service.MusicStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}