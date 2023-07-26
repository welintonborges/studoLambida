package com.example.estudolambida;

import com.example.estudolambida.product.Product;
import com.example.estudolambida.sevices.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EstudoLambidaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EstudoLambidaApplication.class, args);

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("HD", 80.90));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(list, product -> product.getName().charAt(0) == 'T');
        double sum2 = ps.filteredSum(list, product -> product.getName().charAt(0) == 'M');

        System.out.println("Sum = " + String.format("%.2f", sum));
        System.out.println("Sum2 = " + String.format("%.2f", sum2));

//        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
//
//        for (Product p : list) {
//            System.out.println(p);
//        }
//
//        System.out.println("aqui");
    }

}
