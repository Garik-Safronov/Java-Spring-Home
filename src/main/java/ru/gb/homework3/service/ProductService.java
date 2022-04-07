package ru.gb.homework3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework3.repository.ProductRepository;
import ru.gb.homework3.model.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.saveProduct(product);
    }

    public Product findById(Integer id) {
        return productRepository.findProductById(id);
    }

    public List<Product> findAll() {
        return productRepository.allProductList();
    }

    public void deleteById(Integer id) {
        productRepository.deleteProductById(id);
    }
}
