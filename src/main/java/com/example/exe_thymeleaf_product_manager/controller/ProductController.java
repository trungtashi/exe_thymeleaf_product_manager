package com.example.exe_thymeleaf_product_manager.controller;

import com.example.exe_thymeleaf_product_manager.service.IProductService;
import com.example.exe_thymeleaf_product_manager.service.ProductService;
import model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();
    @GetMapping("")
    public String index(Model model){
        List<Products> productsList = productService.findAll();
        model.addAttribute("products", productsList);
        return "/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product", new Products());
        return "/create";
    }
    @PostMapping("/save")
    public String save(Products products) {
        products.setId((int) (Math.random() * 10000));
        productService.save(products);
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/edit";
    }
    @PostMapping("/update")
    public String update(Products products) {
        productService.update(products.getId(), products);
        return "redirect:/product";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public String delete(Products products, RedirectAttributes redirect) {
        productService.remove(products.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }
}
