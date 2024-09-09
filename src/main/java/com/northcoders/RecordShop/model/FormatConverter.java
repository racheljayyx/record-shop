package com.northcoders.RecordShop.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FormatConverter implements AttributeConverter<Format, String> {
    @Override
    public String convertToDatabaseColumn(Format format) {
        if (format == null) {
            return null;
        }
        return format.getName();
    }

    @Override
    public Format convertToEntityAttribute(String name) {
        if(name == null || name.isEmpty()) {
            return null;
        }
        return Format.getFormatFromName(name);
    }
}
