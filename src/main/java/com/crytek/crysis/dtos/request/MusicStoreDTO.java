package com.crytek.crysis.dtos.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record MusicStoreDTO(
        @NotBlank
        String  title,
        @NotNull
        Long genre,
        @NotBlank
        Set<String> names
) {
}
