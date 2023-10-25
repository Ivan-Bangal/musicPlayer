package com.crytek.crysis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Playlist {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    
    @Column
    @NonNull
    private String name;

    @OneToMany
    private List<Music> musicList;
    
}
