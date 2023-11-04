package com.crytek.crysis.enums;

import lombok.Getter;

@Getter
public enum ContentType {

    AUDIO("audio");
    private  final String value;

    ContentType(String value) {
        this.value = value;
    }
}
