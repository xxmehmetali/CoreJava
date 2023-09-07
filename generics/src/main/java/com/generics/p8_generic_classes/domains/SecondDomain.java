package com.generics.p8_generic_classes.domains;

public class SecondDomain {

    private int secondDomainPrivateInt;

    public SecondDomain(int secondDomainPrivateInt) {
        this.secondDomainPrivateInt = secondDomainPrivateInt;
    }

    @Override
    public String toString() {
        return "SecondDomain{" +
                "secondDomainPrivateInt=" + secondDomainPrivateInt +
                '}';
    }
}
