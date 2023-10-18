package com.generics.p15_multiple_upperbound_types;

import com.generics.p15_multiple_upperbound_types.domains.ColorProduct;
import com.generics.p15_multiple_upperbound_types.domains.CustomProduct;
import com.generics.p15_multiple_upperbound_types.domains.Product;
import com.generics.p15_multiple_upperbound_types.domains.SizeProduct;
import com.generics.p15_multiple_upperbound_types.services.ProductService;
import com.generics.p15_multiple_upperbound_types.services.ProductService2;


public class Main {
    public static void main(String[] args) {
        ColorProduct product1 = new ColorProduct();
        ColorProduct product1_2 = new ColorProduct();

        SizeProduct product2 = new SizeProduct();
        SizeProduct product2_2 = new SizeProduct();

        CustomProduct product3 = new CustomProduct();
        CustomProduct product3_2 = new CustomProduct();

        ProductService<SizeProduct> productService1 = new ProductService<SizeProduct>(product2, product2_2);
        ProductService<ColorProduct> productService2 = new ProductService<ColorProduct>(product1, product1_2);

        /**You cannot create this instance of service because it is not suitable with generic parameterized type.
        It extens Product but doesnt implement Buyable interface. So it is not suitable.**/
//        ProductService<CustomProduct> productService3 = new ProductService<CustomProduct>();

        /** ------------------*/

        ProductService2<ColorProduct> productService2_1 = new ProductService2<ColorProduct>();
        /**Below line will fail just because it doesn't implement Buyable interface*/
        //ProductService2<CustomProduct> productService2_2 new ProductService2<CustomProduct>();

    }
}
