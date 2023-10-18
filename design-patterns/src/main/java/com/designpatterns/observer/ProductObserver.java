package com.designpatterns.observer;

import com.designpatterns.observer.domains.Product;

public interface ProductObserver {
    void productStateChanged(Product product);
}
