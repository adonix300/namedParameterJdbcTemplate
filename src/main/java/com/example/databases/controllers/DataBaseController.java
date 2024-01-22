package com.example.databases.controllers;

import com.example.databases.records.User;
import com.example.databases.repositories.DataBaseRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataBaseController {
    private final DataBaseRepository repository;

    public DataBaseController(DataBaseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProduct(@Validated User user) {
        return repository.getProductName(user.name());
    }
}
