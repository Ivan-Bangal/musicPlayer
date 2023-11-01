package com.crytek.crysis.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

import lombok.Data;

@Entity
@Data
public class MusicFile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column
    @NonNull
    private String name;

    @Column
    private String type;

    @Column
    @Lob
    private byte[] data;

    @OneToOne
    private Music music;

    @Column
    private String path;


    public MusicFile() {
    }

    public MusicFile(long id, String name, String type, byte[] data, Music music, String path) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.data = data;
        this.music = music;
        this.path = path;
    }

    public MusicFile(String name, String type, String path, Music music) {
        this.name = name;
        this.type = type;
        this.music = music;
        this.path = path;
	}



    
   
   

}
