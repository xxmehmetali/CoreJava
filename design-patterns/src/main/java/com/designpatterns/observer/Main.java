package com.designpatterns.observer;

import com.designpatterns.observer.domains.Product;
import com.designpatterns.observer.services.logger.LoggerService;
import com.designpatterns.observer.services.logger.impl.LoggerServiceImpl;
import com.designpatterns.observer.services.product.ProductService;
import com.designpatterns.observer.services.product.impl.ProductServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program Starts\n--------------------------\n");
        ProductService productService = new ProductServiceImpl();
        LoggerService loggerService = new LoggerServiceImpl();

        Product product = new Product("Product 1", 100f, 1);
        product.addObserver((ProductObserver) productService);
        product.addObserver((ProductObserver) loggerService);

        product.setValues("Product 2", 200f, 2);

        //---
        System.out.println("--------------\n");

        product.removeObserver((ProductObserver) productService);
        product.setValues("Product 3", 300f, 3);

        //---
        System.out.println("--------------\n");
        product.addObserver((ProductObserver) productService);
        product.removeObserver((ProductObserver) loggerService);
        product.setValues("Product 4", 400f, 4);



    }
}
