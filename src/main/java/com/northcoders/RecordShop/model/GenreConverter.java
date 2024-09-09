package com.northcoders.RecordShop.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenreConverter implements AttributeConverter<Genre, String> {


    @Override
    public String convertToDatabaseColumn(Genre genre) {
        if (genre == null) {
            return null;
        }
        return genre.getName();
    }

    @Override
    public Genre convertToEntityAttribute(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }

        return Genre.getGenreFromName(name);
    }
}
