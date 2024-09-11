package com.northcoders.RecordShop.service;

import com.northcoders.RecordShop.model.Record;
import com.northcoders.RecordShop.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecordShopServiceImpl implements RecordShopService {

    @Autowired
    RecordShopRepository recordShopRepository;

    @Override
    public List<Record> getAllRecords() {
        List<Record> records = new ArrayList<>();
        recordShopRepository.findAll().forEach(records::add);
        return records;
    }

    @Override
    public Optional<Record> getRecordById(Long id) {
        return recordShopRepository.findById(id);
    }

    @Override
    public Record insertRecord(Record record) {
        return recordShopRepository.save(record);
    }
}
