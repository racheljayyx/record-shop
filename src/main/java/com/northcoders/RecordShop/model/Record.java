package com.northcoders.RecordShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Record {

    @Id
    @GeneratedValue()
    private Long id;

    @Column
    private String name;

    @Column
    private String artist;

    @Column
    @Convert(converter = GenreConverter.class)
    private Genre genre;

    @Column
    @Convert(converter = FormatConverter.class)
    private Format format;

    @Column
    private int quantity;

    @Column
    private int priceInPence;


}
