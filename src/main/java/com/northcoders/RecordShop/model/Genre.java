package com.northcoders.RecordShop.model;

import jakarta.persistence.Converter;
import lombok.Getter;

@Getter
public enum Genre {
    GOSPEL("gospel"),
    RNB("rnb"),
    CLASSICAL("classical"),
    POP("pop"),
    COUNTRY("country"),;

    final String name;

    Genre(final String name) {
        this.name = name;
    }

    public static Genre getGenreFromName(String name) {
        for (Genre genre : Genre.values()) {
            if(genre.getName().equals(name)) {
                return genre;
            }
        }
        throw new IllegalArgumentException("Invalid genre name: " + name);
    }

}
