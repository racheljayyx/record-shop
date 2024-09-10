package com.northcoders.RecordShop.controller;


import com.northcoders.RecordShop.model.Record;
import com.northcoders.RecordShop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
