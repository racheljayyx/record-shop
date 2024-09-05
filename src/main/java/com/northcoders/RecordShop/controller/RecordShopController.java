package com.northcoders.RecordShop.controller;


import com.northcoders.RecordShop.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/albums")
public class RecordShopController {

    @Autowired
    RecordShopService recordShopService;

    @GetMapping
    public
}
