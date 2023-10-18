package com.generics.p15_multiple_upperbound_types.services;

import com.generics.p15_multiple_upperbound_types.domains.Buyable;

//If it doesnt extend anything but you want only the class to implement some interface, you will not use implements keyword.
//In generics you have to use extends keyword for classes and interfaces both.
public class ProductService2<E extends Buyable> {
}


//Notice that Refundable doesn't belong to ==>> ( T extends Buyable )
//These 2 acts as different parameters.
// (T extends Buyable) is something and (Refundable) is something
class ProductService3<T extends Buyable, Refundable>{

}
