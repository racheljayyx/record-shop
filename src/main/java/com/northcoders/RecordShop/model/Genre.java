package com.northcoders.RecordShop.model;

import lombok.Getter;

@Getter
public enum Genre {
    GOSPEL("gospel", 1L),
    RNB("rnb", 2L),
    CLASSICAL("classical", 3L),
    POP("pop", 4L),
    COUNTRY("country", 5L),;

    final String genre;
    final Long id;

    Genre(final String genre, final Long id) {
        this.genre = genre;
        this.id = id;
    }


}
