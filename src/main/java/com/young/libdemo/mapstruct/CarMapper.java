package com.young.libdemo.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


/**
 * @author yangzongxu
 * @date 2019/4/11
 * @description
 */

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    @Mappings({
            @Mapping(source = "numberOfSeats", target = "seatCount"),
            @Mapping(target = "make", ignore = true)
    })
    CarDto carToCarDto(Car car);
}
