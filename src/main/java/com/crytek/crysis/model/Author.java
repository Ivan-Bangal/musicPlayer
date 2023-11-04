package com.crytek.crysis.model;

import javax.persistence.*;

import com.crytek.crysis.dtos.request.AuthorRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private String name;
    private String adress;
    private String nickName;


    public Author(AuthorRequestDTO dto){
        this.adress=dto.adress();
        this.name=dto.name();
        this.nickName=dto.nickName();
    }
}
