package com.crytek.crysis.model;

import java.util.Objects;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import lombok.Data;

@Entity
@Data
@Table(name = "music_file")
@NoArgsConstructor
@AllArgsConstructor
public class MusicFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    @OneToOne
    private Music music;
    private String path;


    public MusicFile(String name, String type, String path, Music music) {
        this.name = name;
        this.type = type;
        this.music = music;
        this.path = path;
	}



    
   
   

}
