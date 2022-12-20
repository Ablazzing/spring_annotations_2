package com.example.spring_annotations_2;

import com.example.spring_annotations_2.entity.Car;
import com.example.spring_annotations_2.entity.CarModel;
import com.example.spring_annotations_2.entity.CarSpy;
import com.example.spring_annotations_2.entity.MyLog;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Car.class.getClassLoader());
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback((MethodInterceptor) (o, method, methodArgs, methodProxy) -> {
            if (method.isAnnotationPresent(MyLog.class)) {
                System.out.printf("%s - run\n", method.getName());
            }
            return methodProxy.invokeSuper(o, methodArgs);
        });

        Car car = (Car) enhancer.create(new Class[]{CarModel.class}, new Object[]{CarModel.BMW});
        car.getCarModel();


    }
}
