package com.northcoders.RecordShop.model;

import lombok.Getter;

@Getter
public enum Format {
    CD("cd", 1L),
    DVD("dvd", 2L),
    DIGITAL("digital", 3L);

    final String format;
    final Long id;

    Format(final String format, final Long id) {
        this.format = format;
        this.id = id;
    }
}
