package ru.gb.homework3.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.homework3.model.Product;
import ru.gb.homework3.service.ProductService;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private ProductService productService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProductId(Model model, @PathVariable Integer id) {
        Product product;
        product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public String getAllProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product-list";
    }

    @RequestMapping(path = "/delete", method = RequestMethod.GET)
    public String deleteById(@RequestParam Integer id) {
        productService.deleteById(id);
        return "redirect:/product/all";
    }
}