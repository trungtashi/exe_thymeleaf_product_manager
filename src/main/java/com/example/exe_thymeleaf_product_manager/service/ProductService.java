package com.example.exe_thymeleaf_product_manager.service;

import model.Products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Products> product;

    static {

        product = new HashMap<>();
        product.put(1, new Products(1, "Tivi",20.000000,"Màn hình siêu phẳng","Sony"));
        product.put(2, new Products(2, "Tủ Lạnh",30.000000,"Ngăn mát siêu to khổng lồ","Panasonic"));
        product.put(3, new Products(3, "Loa",6.000000,"Âm thanh sịn","Sony"));
        product.put(4, new Products(4, "Máy giặt",9.000000,"Giặt siêu sách","Sony"));
        product.put(5, new Products(5, "Điều hòa",11.000000,"Siêu tiết kiệm điện","LG"));
    }

    @Override
    public List<Products> findAll() {
        return new ArrayList<>(product.values());
    }

    @Override
    public void save(Products products) {
        product.put(products.getId(), products);
    }

    @Override
    public Products findById(int id) {
        return product.get(id);
    }

    @Override
    public void update(int id, Products products) {
        product.put(id, products);

    }

    @Override
    public void remove(int id) {
        product.remove(id);
    }
}
