package com.northcoders.RecordShop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
