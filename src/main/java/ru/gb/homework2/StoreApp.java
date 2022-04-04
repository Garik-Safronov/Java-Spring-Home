package ru.gb.homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class StoreApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StoreConfig.class);

        Random r = new Random();
        Cart cart = context.getBean(Cart.class);
        for (int i = 0; i < r.nextInt(5) + 1; i++) {
            cart.addProductToCart(r.nextInt(5) + 1);
        }
        cart.showAllProductsInCart();
    }
}