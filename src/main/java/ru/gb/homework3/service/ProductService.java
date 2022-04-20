package ru.gb.homework3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.homework3.repository.ProductRepository;
import ru.gb.homework3.entity.Product;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> findAll()  {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}