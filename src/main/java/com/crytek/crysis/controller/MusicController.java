package com.crytek.crysis.controller;


import java.util.List;

import com.crytek.crysis.model.Music;
import com.crytek.crysis.model.MusicFile;
import com.crytek.crysis.repository.MusicFileRepository;
import com.crytek.crysis.repository.MusicRepository;
import com.crytek.crysis.service.MusicStorageService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/music")
public class MusicController {
    
    @Autowired
    private MusicRepository musicRepo;

    @Autowired
    private MusicFileRepository fileRepo;

    @Autowired
    private MusicStorageService service;


    @GetMapping()
    public String entry(Model model) {
        List<MusicFile> files = fileRepo.findAll();
        model.addAttribute("musics", files);
        return "music/entry";
    }

    @GetMapping("/create")
    public String createMusic(Model model) {
        model.addAttribute("music", new Music());
        return "music/create";
    }

    @PostMapping("/insert")
    public String insert(Model model,@ModelAttribute Music music,@ModelAttribute MultipartFile mp3){
        musicRepo.save(music);
        service.storeFile(mp3, music);
        return "redirect:/music";
    }

    

}
