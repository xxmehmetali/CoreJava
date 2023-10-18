package com.generics.p15_multiple_upperbound_types.domains;

public class ColorProduct extends Product implements Buyable {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void sell() {

    }
}
