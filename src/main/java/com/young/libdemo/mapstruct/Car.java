package com.young.libdemo.mapstruct;

import lombok.Data;

/**
 * @author yangzongxu
 * @date 2019/4/11
 * @description
 */
@Data
public class Car {
    private String make;
    private int numberOfSeats;


    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Ben4");
        car.setNumberOfSeats(1);
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
        System.out.println(carDto);
    }


}
