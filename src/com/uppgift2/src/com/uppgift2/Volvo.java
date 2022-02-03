package com.uppgift2;

import java.util.Random;

public class Volvo implements CarInfo {

    private int id;

    public Volvo() {
        Random random = new Random();
        this.id = random.nextInt(101201020,909839272);
    }

    @Override
    public String info() {
        return "A brand new Volvo was created, with an id of: " + this.id;
    }
}
