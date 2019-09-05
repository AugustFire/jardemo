package com.young.libdemo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author: yzx
 * @date: 2018/8/21
 * @description: pojo
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class User {
    private static final String xx = "AA";
    private String name;
    private Integer age;
    private String type;
    private String email;

    public User(String name, Integer age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public static void main(String[] args) {

    }

    public void sa() {
        System.out.println(1);
    }
}
