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

@Entity
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

	public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Music getMusic() {
        return this.music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MusicFile id(long id) {
        this.id = id;
        return this;
    }

    public MusicFile name(String name) {
        this.name = name;
        return this;
    }

    public MusicFile type(String type) {
        this.type = type;
        return this;
    }

    public MusicFile data(byte[] data) {
        this.data = data;
        return this;
    }

    public MusicFile music(Music music) {
        this.music = music;
        return this;
    }

    public MusicFile path(String path) {
        this.path = path;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MusicFile)) {
            return false;
        }
        MusicFile musicFile = (MusicFile) o;
        return id == musicFile.id && Objects.equals(name, musicFile.name) && Objects.equals(type, musicFile.type) && Objects.equals(data, musicFile.data) && Objects.equals(music, musicFile.music) && Objects.equals(path, musicFile.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, data, music, path);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", type='" + getType() + "'" +
            ", data='" + getData() + "'" +
            ", music='" + getMusic() + "'" +
            ", path='" + getPath() + "'" +
            "}";
    }
   

}
