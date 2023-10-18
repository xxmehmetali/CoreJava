package com.designpatterns.observer.services.logger;

import com.designpatterns.observer.domains.Product;

public interface LoggerService {
    void logProduct(Product product);
}
