package ru.gb.homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> productListInCart = new ArrayList<>();
    private ProductRepository repository;

    @Autowired
    public Cart(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProductToCart(int id) {
        if (repository.findProductById(id) != null) {
            Product product = repository.findProductById(id);
            productListInCart.add(product);
        } else {
            System.out.println("Этого продукта нет в магазине");
        }
    }

    public void deleteProductFromCart(int id) {
        for (Product p : productListInCart) {
            if (p.getId() == id) {
                productListInCart.remove(p);
                return;
            }
        }
        System.out.println("Этого продукта нет в корзине");
    }

    public void showAllProductsInCart() {
        System.out.println("В корзину добавлены следующие продукты:");
        System.out.println(productListInCart);
    }
}
