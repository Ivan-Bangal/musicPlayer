package com.crytek.crysis.dtos.request;

import jakarta.validation.constraints.NotBlank;
import org.springframework.transaction.annotation.EnableTransactionManagement;


public record AuthorRequestDTO(
       @NotBlank(message = "O nome do autor nao pode ser nulo")
        String name,
       @NotBlank(message = "O endereco do autor nao pode ser nulo")
       String adress,
       @NotBlank(message = "O Nickname do autor nao pode ser nulo")
       String nickName

) {
}
