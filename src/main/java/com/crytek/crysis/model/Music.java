package com.crytek.crysis.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.sun.tools.javac.jvm.Gen;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "music")
public class Music {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String titulo;
    @OneToOne
    private MusicFile musicFile;
    @ManyToOne
    private Genre genre;



    

}
