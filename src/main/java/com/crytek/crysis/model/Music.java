package com.crytek.crysis.model;


import com.crytek.crysis.dtos.request.MusicStoreDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "music")
public class Music {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String title;
    @OneToOne
    private MusicFile musicFile;
    @ManyToOne
    private Genre genre;

    public Music(Genre genre, MusicStoreDTO dto){
        this.genre= genre;
        this.title=dto.title();
    }



    

}
