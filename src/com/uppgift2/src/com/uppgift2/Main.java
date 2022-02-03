package com.uppgift2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        List<CarInfo> carInfos = new ArrayList<>();
        carInfos.add(carFactory.buildCar(CarType.LEXUS));
        carInfos.add(carFactory.buildCar(CarType.FORD));
        carInfos.add(carFactory.buildCar(CarType.VOLVO));

        carInfos.forEach(car -> System.out.println(car.info()));

    }
}
