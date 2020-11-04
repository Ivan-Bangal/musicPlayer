package com.crytek.crysis.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Music {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column
    @NonNull
    private String autor;

    @Column
    @NonNull
    private String titulo;

    public Music() {
    }

    public Music(String autor, String titulo) {
        this.autor = autor;
        this.titulo = titulo;
    }

    public Music(long id, String autor, String titulo) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Music id(long id) {
        this.id = id;
        return this;
    }

    public Music autor(String autor) {
        this.autor = autor;
        return this;
    }

    public Music titulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Music)) {
            return false;
        }
        Music music = (Music) o;
        return id == music.id && Objects.equals(autor, music.autor) && Objects.equals(titulo, music.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, titulo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", autor='" + getAutor() + "'" +
            ", titulo='" + getTitulo() + "'" +
            "}";
    }


}
