package com.example.exe_thymeleaf_product_manager.service;

import model.Products;

import java.util.List;

public interface IProductService {
    List<Products> findAll();

    void save(Products products);

    Products findById(int id);

    void update(int id, Products products);
    void remove(int id);
}
