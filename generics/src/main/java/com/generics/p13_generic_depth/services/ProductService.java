package com.generics.p13_generic_depth.services;

import com.generics.p13_generic_depth.domains.Product;

public class ProductService<T extends Product> {
    private T product1;
    private T product2;

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

    /** You can perform this action just because this class has generic : <T extends Product>. You know that T extends Product so you can use any of method of Product
     * Compiler doesn't know if it is SizeProduct or ColorProduct. It only knows this type extends Product. So you cannot use SizeProduct or ColorProduct's methods.
     * */
    public boolean isCompatible(){
        return product1.getProductType().equals(product2.getProductType());
    }
}
