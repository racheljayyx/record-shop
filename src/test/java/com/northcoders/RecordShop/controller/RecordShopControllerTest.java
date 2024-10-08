package com.northcoders.RecordShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.RecordShop.model.Format;
import com.northcoders.RecordShop.model.Genre;
import com.northcoders.RecordShop.model.Record;
import com.northcoders.RecordShop.service.RecordShopServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class RecordShopControllerTest {

    @Mock
    private RecordShopServiceImpl mockRecordShopServiceImpl;

    @InjectMocks
    private RecordShopController recordShopController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(recordShopController).build();
        mapper = new ObjectMapper();
    }

    @Test
    public void testGetAllRecordsReturnsListOfRecords() throws Exception {

        List<com.northcoders.RecordShop.model.Record> records = new ArrayList<>();
        records.add(new com.northcoders.RecordShop.model.Record(1L, "The Great Commission", "Dunsin Oyekan", Genre.GOSPEL, Format.DIGITAL, 5, 100));
        records.add(new com.northcoders.RecordShop.model.Record(2L, "The 50 Greatest Pieces of Classical Music", "London Philharmonic Orchestra", Genre.CLASSICAL, Format.CD, 1, 87));
        records.add(new Record(3L, "Won't Be Blue Anymore", "Dan Seals", Genre.COUNTRY, Format.VINYL, 19, 69));

        when(mockRecordShopServiceImpl.getAllRecords()).thenReturn(records);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/recordshop/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("The Great Commission"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].artist").value("London Philharmonic Orchestra"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].quantity").value(19));
    }

    @Test
    public void testGetRecordByIdReturnsRecordWhenExists() throws Exception {

        Record record = new Record(1L, "The Great Commission", "Dunsin Oyekan", Genre.GOSPEL, Format.DIGITAL, 5, 100);

        Optional<Record> optionalRecord = Optional.of(record);

        when(mockRecordShopServiceImpl.getRecordById(1L)).thenReturn(optionalRecord);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/recordshop/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("The Great Commission"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artist").value("Dunsin Oyekan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("GOSPEL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.format").value("DIGITAL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceInPence").value(100));
    }

    @Test
    public void testPostMappingAddRecord() throws Exception {
        Record record = new Record(4L, "Chandler Moore: Live in Los Angeles", "Chandler Moore", Genre.GOSPEL, Format.DIGITAL, 5, 121);

        when(mockRecordShopServiceImpl.insertRecord(record)).thenReturn(record);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.post("/api/v1/recordshop/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(record)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Chandler Moore: Live in Los Angeles"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.artist").value("Chandler Moore"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genre").value("GOSPEL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.format").value("DIGITAL"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.quantity").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceInPence").value(121));

        verify(mockRecordShopServiceImpl, times(1)).insertRecord(record);
    }

    @Test
    public void testDeleteMappingDeleteByRecordId() throws Exception {
        Record record = new Record(1L, "The Great Commission", "Dunsin Oyekan", Genre.GOSPEL, Format.DIGITAL, 5, 100);

        doNothing().when(mockRecordShopServiceImpl).deleteRecordById(1L);

        this.mockMvcController.perform(
                MockMvcRequestBuilders.delete("/api/v1/recordshop/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Record with id: 1 has been deleted"));

        verify(mockRecordShopServiceImpl, times(1)).deleteRecordById(1L);
    }

}
