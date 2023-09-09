package com.generics.p17_generics_with_static_methods.services;


import com.generics.p17_generics_with_static_methods.domains.CustomProduct;
import com.generics.p17_generics_with_static_methods.domains.Product;

public class ProductService<E extends Product> {

    private E product;

    public void operationOnBelongingProduct(){
        System.out.println(product.getProductField());
    }

    /**
        note that static method's E type is not related with the E beside of the class. These 2 E's are completely different.
        Syntax is like this : access_modifier static YOUR_WILD_CARD return_type method_name(params){body}
        wildcard is between static and return type.
        in parameters of this method, <E extends CustomProduct> will be used to get generic parameters.
     * */
    public static <E extends CustomProduct> void operationOnExternalProduct(E product){
        System.out.println(product.getCustomProductField());
    }

    public E getProduct() {
        return product;
    }

    public void setProduct(E product) {
        this.product = product;
    }
}
