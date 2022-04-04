package ru.gb.homework2;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private int id;
    private String title;
    private double price;
}
