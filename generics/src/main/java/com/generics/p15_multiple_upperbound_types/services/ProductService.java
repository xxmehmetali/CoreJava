package com.generics.p15_multiple_upperbound_types.services;

import com.generics.p15_multiple_upperbound_types.domains.Buyable;
import com.generics.p15_multiple_upperbound_types.domains.Product;

public class ProductService<T extends Product & Buyable> {
    private T product1;
    private T product2;

    public ProductService() {
    }

    public ProductService(T product1, T product2) {
        this.product1 = product1;
        this.product2 = product2;
    }

    public T getProduct1() {
        return product1;
    }

    public void setProduct1(T product1) {
        this.product1 = product1;
    }

    public T getProduct2() {
        return product2;
    }

    public void setProduct2(T product2) {
        this.product2 = product2;
    }

    public void doSomethingWithProduct(){
        //These operations has been able to done just because we know that this T type extens product type (it has getProductType() method)
        //and implements Buyable interface (which has sell() method)

        product1.sell();
        product2.sell();

        product1.getProductType();
        product2.getProductType();
    }
}
