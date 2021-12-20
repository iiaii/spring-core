package com.example.springcore.singleton;

public class StatefulService {

    private int price;

    public void order(final String name, final int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
