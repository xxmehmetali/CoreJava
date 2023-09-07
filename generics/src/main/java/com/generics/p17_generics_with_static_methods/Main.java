package com.generics.p17_generics_with_static_methods;

import com.generics.p17_generics_with_static_methods.domains.CustomProduct;
import com.generics.p17_generics_with_static_methods.domains.USAProduct;
import com.generics.p17_generics_with_static_methods.services.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService<CustomProduct> productService = new ProductService<CustomProduct>();
        CustomProduct customProduct = new CustomProduct();
        customProduct.setCustomProductField("customProductField___");
        customProduct.setProductField("productFieldFromCustomProduct__");

        productService.setProduct(customProduct);
        productService.operationOnBelongingProduct();
        /**---------------*/
        //Static context with generics

        USAProduct usaProduct = new USAProduct();
        usaProduct.setCountry("USA");
        usaProduct.setProductField("USAProductField");
        usaProduct.setCustomProductField("USACustomProductField");
        ProductService.operationOnExternalProduct(usaProduct);


    }
}
