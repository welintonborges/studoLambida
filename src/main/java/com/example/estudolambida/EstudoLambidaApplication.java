package com.example.estudolambida;

import com.example.estudolambida.product.Product;
import com.example.estudolambida.sevices.ProductService;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EstudoLambidaApplication {

    public static void main(String[] args) {

//        SpringApplication.run(EstudoLambidaApplication.class, args);

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

        System.out.println("-------------------------------STREAM INTEIROS----------------------------------------------" );

        List<Integer> listInter = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = listInter.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        System.out.println("-------------------------------STREAM STRINGS----------------------------------------------" );

        Stream<String> st2 = Stream.of("Jennfar", "Welinton", "Eliz");
        System.out.println(Arrays.toString(st2.toArray()));

        System.out.println("-------------------------------STREAM INTERETION----------------------------------------------" );

        Stream<Integer> st3 = Stream.iterate(0, x-> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));


        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

        System.out.println("-------------------------------STREAM PIPELINE----------------------------------------------" );

        List<Integer> listInterPipeline = Arrays.asList(6, 8, 10, 21, 14);

        Stream<Integer> st5 = listInterPipeline.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st5.toArray()));

        int sumPipeline = listInterPipeline.stream().reduce(0, (x, y) -> x + y);
        System.out.println("SUM = " + sumPipeline);

        List<Integer> newList = listInterPipeline.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10 )
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));

//        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
//
//        for (Product p : list) {
//            System.out.println(p);
//        }
//
//        System.out.println("aqui");
    }

}
