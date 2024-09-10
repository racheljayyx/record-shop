package com.northcoders.RecordShop.service;

import com.northcoders.RecordShop.model.Format;
import com.northcoders.RecordShop.model.Genre;
import com.northcoders.RecordShop.model.Record;
import com.northcoders.RecordShop.repository.RecordShopRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.mockito.Mockito.*;

@DataJpaTest
public class RecordShopServiceTests {

    @Mock
    private RecordShopRepository mockRecordShopRepository;

    @InjectMocks
    private RecordShopServiceImpl recordShopServiceImpl;

    @Test
    public void testGetAllAlbumsReturnsListOfAlbums() {
        List<Record> records = new ArrayList<>();
        records.add(new Record(1L, "The Great Commission", "Dunsin Oyekan", Genre.GOSPEL, Format.DIGITAL, 5, 100));
        records.add(new Record(2L, "The 50 Greatest Pieces of Classical Music", "London Philharmonic Orchestra", Genre.CLASSICAL, Format.CD, 1, 87));
        records.add(new Record(3L, "Won't Be Blue Anymore", "Dan Seals", Genre.COUNTRY, Format.VINYL, 19, 69));


        when(mockRecordShopRepository.findAll()).thenReturn(records);

        List<Record> actualResult = recordShopServiceImpl.getAllRecords();

        assertThat(actualResult).hasSize(3);
        assertThat(actualResult).isEqualTo(records);
    }

    @Test
    public void testGetRecordByIdReturnsRecordWhenExists() {

        Record record = new Record(1L, "The Great Commission", "Dunsin Oyekan", Genre.GOSPEL, Format.DIGITAL, 5, 100);

        
        Optional<Record> optionalRecord = Optional.of(record);

        when(mockRecordShopRepository.findById(1L)).thenReturn(optionalRecord);

        Record actualResult = recordShopServiceImpl.getRecordById(1L).get();

        assertThat(actualResult).isEqualTo(record);
        verify(mockRecordShopRepository, times(1)).findById(1L);

    }

//    @Test
//    public void testAddRecord() {
//        var record = new Record(4L, "Chandler Moore: Live in Los Angeles", "Chandler Moore", Genre.GOSPEL, Format.DIGITAL, 5, 121);
//
//        when(mockRecordShopRepository.save(record)).thenReturn(record);
//
//        List<Record> actualResult = recordShopServiceImpl.insertRecord(record);
//
//        assertThat(actualResult).isEqualTo(record);
//
//    }

}
