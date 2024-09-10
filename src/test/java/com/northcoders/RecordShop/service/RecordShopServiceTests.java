package com.northcoders.RecordShop.service;

import com.northcoders.RecordShop.model.Record;
import com.northcoders.RecordShop.repository.RecordShopRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
public class RecordShopServiceTests {

    @Mock
    private RecordShopRepository mockRecordShopRepository;

    @InjectMocks
    private RecordShopServiceImpl recordShopServiceImpl;

    @Test
    public void testGetAllAlbumsReturnsListOfAlbums() {
        List<Record> records = new ArrayList<>();
        records.add(new Record(1L, "The Great Commission", "Dunsin Oyekan", "gospel", "digital", 5, 100));
        records.add(new Record(2L, "The 50 Greatest Pieces of Classical Music", "London Philharmonic Orchestra", "classical", "cd", 1, 87));
        records.add(new Record(3L, "Won't Be Blue Anymore", "Dan Seals", "country", "vinyl", 19, 69));


        when(mockRecordShopRepository.findAll()).thenReturn(records);

        List<Record> actualResult = recordShopServiceImpl.getAllRecords();

        assertThat(actualResult).hasSize(3);
        assertThat(actualResult).isEqualTo(records);
    }

    @Test
    public void testAddRecord() {
        var record = new Record(4L, "Chandler Moore: Live in Los Angeles", "Chandler Moore", "gospel", "digital", 5, 121);

        when(mockRecordShopRepository.save(record)).thenReturn(record);

        List<Record> actualResult = recordShopServiceImpl.insertRecord(record);

        assertThat(actualResult).isEqualTo(record);

    }

}
