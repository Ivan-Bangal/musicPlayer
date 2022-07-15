package com.crytek.crysis.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import static java.nio.file.FileSystems.getDefault;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import com.crytek.crysis.model.Author;
import com.crytek.crysis.model.Music;
import com.crytek.crysis.model.MusicFile;
import com.crytek.crysis.repository.MusicFileRepository;
import com.crytek.crysis.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MusicStorageService {

    private static String BASE_URL = "uploads";

    private static String SERVER_URL;

    @Autowired
    private MusicFileRepository fileRepo;

    @Autowired
    private MusicRepository repo;

    private Path root = Paths.get(BASE_URL);

    @PostConstruct
    public void init() {
        try {
            root = getDefault().getPath(System.getenv("HOME"), "uploads");
            SERVER_URL = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/";
            if (!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException e) {

            throw new RuntimeException("Could not initialize folder for upload!: " + e.getMessage());
        }
    }

    public MusicRepository getRepo() {
        return repo;
    }

    public MusicFile storeFile(MultipartFile file, Music music) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()).replace(" ", "_");

        try {

            if (!file.getContentType().contains("audio")) {
                throw new RuntimeException("Can't Save Audio");
            }

            for (Author author : music.getAuthors()) {

                MultipartFile copy = file;
                
                Path fileDirectory = Paths.get(System.getenv("HOME") + getDefault().getSeparator() + BASE_URL
                        + getDefault().getSeparator() + author.getName());

                if (!Files.exists(fileDirectory)) {
                    Files.createDirectory(fileDirectory);
                }

                copy.transferTo(new File(this.root.toAbsolutePath().toString() + getDefault().getSeparator()
                        + author.getName() + getDefault().getSeparator() + fileName));

                MusicFile dbFile = new MusicFile(fileName, file.getContentType(),
                        SERVER_URL + BASE_URL + "/" + author.getName() + "/" + fileName, music);

                fileRepo.save(dbFile);

            }

            // Get The Home folder with System.getenv("Home")

            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*
     * Method Responsible for Fetching The File In System Enviroment
     * 
     * @param title
     * 
     * @Param Autor
     */
    public byte[] recover(String title, String autor) {
        try {
            return Files.readAllBytes(this.root.resolve(autor + getDefault().getSeparator() + title));
        } catch (IOException e) {
            throw new RuntimeException("Erro recuperando a foto", e);
        }
    }

    public byte[] recover(Music music) {
        try {

            MusicFile file = fileRepo.findByMusic(music);
            Author author = music.getAuthors().iterator().next();

            return Files.readAllBytes(this.root.resolve(author.getName() + getDefault().getSeparator() + file.getName()));
            
        } catch (IOException e) {
            throw new RuntimeException("Erro recuperando a foto", e);
        }
    }

}
