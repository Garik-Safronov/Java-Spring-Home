package ru.gb.homework2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {

    List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void init(){
        productList.add(new Product(1,"Milk", 80d));
        productList.add(new Product(2,"Chocolate", 50d));
        productList.add(new Product(3,"Eggs", 100d));
        productList.add(new Product(4,"Apples", 150d));
        productList.add(new Product(5,"Meat", 300d));
    }

    public List<Product> allProductList(){
        return productList;
    }

    public Product findProductById(int id){
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new RuntimeException("Товар не нейден");
    }
}
