package com.example.spring_annotations_2.controller;

import com.example.spring_annotations_2.entity.Car;
import com.example.spring_annotations_2.entity.CarModel;
import com.example.spring_annotations_2.entity.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Random;

@RestController
public class CarController {
    @RandomCar
    private Car car;

    @GetMapping("/car")
    @ResponseBody
    @MyLog
    public Car generateCar() {
        return car;
    }

}
