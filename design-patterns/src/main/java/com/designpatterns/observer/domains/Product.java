package com.designpatterns.observer.domains;

import com.designpatterns.observer.ProductObserver;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private double price;
    private int quantity;

    private List<ProductObserver> observers;
    {
        observers = new ArrayList<>();
    }

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void setValues(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        notifyObservers();
    }


    public void addObserver(ProductObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ProductObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        observers.forEach(observer -> observer.productStateChanged(this));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
