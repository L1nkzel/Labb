package com.uppgift2;

import java.util.Random;

public class Lexus implements CarInfo {

    private int id;

    public Lexus() {
        Random random = new Random();
        this.id = random.nextInt(101201020, 909839272);
    }

    @Override
    public String info() {
        return "A brand new Lexus was created, with an id of: " + this.id;
    }
}
