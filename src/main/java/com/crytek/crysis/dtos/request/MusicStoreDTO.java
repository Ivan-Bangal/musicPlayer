package com.crytek.crysis.dtos.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
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
