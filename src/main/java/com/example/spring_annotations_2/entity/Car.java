package com.example.spring_annotations_2.entity;

public class Car {
    private CarModel carModel;

    public Car(CarModel carModel) {
        this.carModel = carModel;
    }

    @MyLog
    public CarModel getCarModel() {
        getInfo();
        return carModel;
    }

    @MyLog
    protected void getInfo() {
        System.out.println("Инфо о машине");
    }
}
