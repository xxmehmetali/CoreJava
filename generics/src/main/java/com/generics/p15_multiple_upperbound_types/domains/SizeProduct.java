package com.generics.p15_multiple_upperbound_types.domains;

public class SizeProduct extends Product implements Buyable {
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void sell() {

    }
}
