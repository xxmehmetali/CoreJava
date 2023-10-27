package com.designpatterns.observer.services.logger.impl;

import com.designpatterns.observer.ProductObserver;
import com.designpatterns.observer.domains.Product;
import com.designpatterns.observer.services.logger.LoggerService;

public class LoggerServiceImpl implements LoggerService, ProductObserver {

    public void logProduct(Product product){
        System.out.println("Product logged: " + product.getName());
    }


    /** What you want to do when the product state changes
     * This method is triggered by the product when its state changes
     * */
    @Override
    public void productStateChanged(Product product) {
        logProduct(product);
    }
}
