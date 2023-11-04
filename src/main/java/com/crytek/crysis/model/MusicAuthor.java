package com.crytek.crysis.model;

import com.crytek.crysis.service.MusicAuthorService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class MusicAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Music music;
    @ManyToOne
    private Author author;

    public MusicAuthor(Music music, Author author){
        this.author=author;
        this.music=music;

    }
}
