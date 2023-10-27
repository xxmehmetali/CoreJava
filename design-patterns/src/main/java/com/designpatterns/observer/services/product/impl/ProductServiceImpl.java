package com.designpatterns.observer.services.product.impl;

import com.designpatterns.observer.domains.Product;
import com.designpatterns.observer.ProductObserver;
import com.designpatterns.observer.services.product.ProductService;

public class ProductServiceImpl implements ProductService, ProductObserver {
    @Override
    public void addProduct(Product product) {
        System.out.println("Product added: " + product.getName());
    }

    @Override
    public void deleteProduct(Product product) {
        System.out.println("Product deleted: " + product.getName());
    }

    public void updateProduct(Product product) {
        System.out.println("Product updated: " + product.getName());
    }

    /** What you want to do when the product state changes
     * This method is triggered by the product when its state changes
     * */
    @Override
    public void productStateChanged(Product product) {
           updateProduct(product);
    }
}
