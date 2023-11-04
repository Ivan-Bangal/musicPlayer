package com.crytek.crysis.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import static java.nio.file.FileSystems.getDefault;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;

import com.crytek.crysis.enums.ContentType;
import com.crytek.crysis.exceptions.NotFoundException;
import com.crytek.crysis.model.Author;
import com.crytek.crysis.model.Music;
import com.crytek.crysis.model.MusicFile;
import com.crytek.crysis.repository.MusicFileRepository;
import com.crytek.crysis.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MusicStorageService {

    @Autowired
    private static String BASE_URL = "uploads";
    @Autowired
    private static String SERVER_URL;
    @Autowired
    private  String HOME_DIRECTORY;
    @Autowired

    private MusicFileRepository fileRepo;
    @Autowired
    private MusicService musicService;
    @Autowired

    private Path root ;


    @PostConstruct
    public void init() {
        try {
            root = getDefault().getPath(HOME_DIRECTORY, "uploads");
            SERVER_URL = "http://" + InetAddress.getLocalHost().getHostAddress() + ":8080/";
            if (!Files.exists(root))
                Files.createDirectory(root);
        } catch (IOException e) {

            throw new RuntimeException("Could not initialize folder for upload!: " + e.getMessage());
        }
    }


   public MusicFile storeFile(MultipartFile file, Long musicId) throws NotFoundException {
       Music music= musicService.findById(musicId);

        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()).replace(" ", "_");
        MusicFile dbFile= null;

        try {

            if (!file.getContentType().contains(ContentType.AUDIO.getValue())) {
                throw new RuntimeException("Can't Save Audio");
            }


                MultipartFile copy = file;
                
                Path fileDirectory = Paths.get(HOME_DIRECTORY + getDefault().getSeparator() + BASE_URL
                        + getDefault().getSeparator() + music.getId());

                if (!Files.exists(fileDirectory)) {
                    Files.createDirectory(fileDirectory);
                }

                copy.transferTo(new File(this.root.toAbsolutePath().toString() + getDefault().getSeparator()
                        + music.getId() + getDefault().getSeparator() + fileName));

                dbFile = new MusicFile(fileName, file.getContentType(),
                        SERVER_URL + BASE_URL + "/" + music.getId() + "/" + fileName, music);

                music.setMusicFile(dbFile);
                fileRepo.save(dbFile);
                musicService.create(music);



            // Get The Home folder with System.getenv("Home")

            return dbFile;
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

   /* public byte[] recover(Music music) {
        try {

            MusicFile file = fileRepo.findByMusic(music);
            Author author = music.getAuthors().iterator().next();

            return Files.readAllBytes(this.root.resolve(author.getName() + getDefault().getSeparator() + file.getName()));
            
        } catch (IOException e) {
            throw new RuntimeException("Erro recuperando a foto", e);
        }
    }

    */

}
