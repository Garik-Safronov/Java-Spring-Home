package ru.gb.homework3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework3.entity.Product;
import ru.gb.homework3.service.ProductService;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public String getProductId(@PathVariable Long id) {
        return productService.findById(id).toString();
    }

    @GetMapping("/all")
    public String getAllProduct(Model model) {
        return productService.findAll().toString();
    }

    @PostMapping("/add")
    public String processForm(Product product) {
        return productService.save(product).toString();
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "Product deleted";
    }
}
