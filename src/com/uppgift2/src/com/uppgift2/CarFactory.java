package com.uppgift2;

public class CarFactory {

    public CarInfo buildCar (CarType type) {
        CarInfo carInfo = null;
        switch (type) {
            case FORD:
                carInfo = new Ford();
                break;
            case LEXUS:
                carInfo = new Lexus();
                break;
            case VOLVO:
                carInfo = new Volvo();
                break;
            default:
        }
        return carInfo;
    }
}
