package com.lambdas.p12_funcinterface_annotation.interfaces;

//If you put this annotation on an interface, you have to have only one contract.
@FunctionalInterface
public interface StringFuncInterface {
    int getLength(String str);

    // if you put more than one contract, you will get compilation error
    // void somethingOther();
}
