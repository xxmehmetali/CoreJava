package com.designpatterns.observer.services.product;

import com.designpatterns.observer.domains.Product;

public interface ProductService {
    void addProduct(Product product);
    void deleteProduct(Product product);
    void updateProduct(Product product);
}
