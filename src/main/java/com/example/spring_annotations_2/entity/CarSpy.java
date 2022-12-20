package com.example.spring_annotations_2.entity;

public class CarSpy {
    private Car car;

    public CarSpy(Car car) {
        this.car = car;
    }

    public CarModel getCarModel() {

        //return callBack();
        return CarModel.BMW;
    }

//    private CarModel callBack() {
//        System.out.println("getCarModel - run");
//        return new CarModel();
//    }
}
