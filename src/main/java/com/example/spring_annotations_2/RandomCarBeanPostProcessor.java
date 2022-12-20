package com.example.spring_annotations_2;

import com.example.spring_annotations_2.controller.RandomCar;
import com.example.spring_annotations_2.entity.Car;
import com.example.spring_annotations_2.entity.CarModel;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class RandomCarBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomCar.class)) {
                if (field.getType() == Car.class) {
                    field.setAccessible(true);
                    System.out.println("Ура создали рандомную машину");
                    ReflectionUtils.setField(field, bean, generateRandomCar());
                }
            }
        }

        return bean;
    }


    private Car generateRandomCar() {
        return new Car(CarModel.values()[new Random().nextInt(4)]);
    }

}
