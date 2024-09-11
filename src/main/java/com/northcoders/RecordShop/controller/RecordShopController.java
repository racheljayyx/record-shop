package com.northcoders.RecordShop.controller;

import com.northcoders.RecordShop.model.Record;
import com.northcoders.RecordShop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recordshop")
public class RecordShopController {

    @Autowired
    RecordShopService recordShopService;

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordShopService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Record>> getEmployeeById(@PathVariable("id") long id){
        return new ResponseEntity<>(recordShopService.getRecordById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Record> addRecord(@RequestBody Record record) {
        Record newRecord = recordShopService.insertRecord(record);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("record", "/api/v1/recordshop" + newRecord.getId().toString());
        return new ResponseEntity<>(newRecord, httpHeaders,HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecordById(@PathVariable("id") long id) {
        recordShopService.deleteRecordById(id);
        return new ResponseEntity<>("Record with id: " + id + " has been deleted", HttpStatus.OK);
    }

}
