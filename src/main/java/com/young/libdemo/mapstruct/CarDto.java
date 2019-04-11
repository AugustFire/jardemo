package com.young.libdemo.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yangzongxu
 * @date 2019/4/11
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDto {
    private String make;
    private int seatCount;
    private String type;

}
