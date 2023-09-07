package com.generics.p8_generic_classes.domains;

public class FirstDomain {
    private String firstDomainPrivateString;

    public FirstDomain(String firstDomainPrivateString) {
        this.firstDomainPrivateString = firstDomainPrivateString;
    }

    @Override
    public String toString() {
        return "FirstDomain{" +
                "firstDomainPrivateString='" + firstDomainPrivateString + '\'' +
                '}';
    }
}
