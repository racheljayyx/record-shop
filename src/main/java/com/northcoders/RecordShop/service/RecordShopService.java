package com.northcoders.RecordShop.service;

import com.northcoders.RecordShop.model.Record;

import java.util.List;
import java.util.Optional;

public interface RecordShopService {
    List<Record> getAllRecords();
    Optional<Record> getRecordById(Long id);
    Record insertRecord (Record record);

}
