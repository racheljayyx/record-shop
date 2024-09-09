package com.northcoders.RecordShop.model;

import lombok.Getter;

@Getter
public enum Format {
    CD("cd"),
    DVD("dvd"),
    DIGITAL("digital");

    final String name;

    Format(final String name) {
        this.name = name;
    }

    public static Format getFormatFromName(String name) {
        for (Format format : Format.values()) {
            if(format.getName().equals(name)) {
                return format;
            }
        }
        throw new IllegalArgumentException("Invalid fromat name: " + name);
    }
}
