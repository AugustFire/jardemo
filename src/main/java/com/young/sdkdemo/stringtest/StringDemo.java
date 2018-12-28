package com.young.sdkdemo.stringtest;

import com.young.libdemo.vo.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: yzx
 * @date: 2018/8/24
 * @description: 关于String常用方法的测试类
 */
public class StringDemo {

    /**
     * 测试string.format
     */
    @Test
    public void stringMethodTest() {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("y",12,"O");
        User user2 = new User("z",19,"AB");
        User user3 = new User("x",3,"A");
        User user4 = new User("c",80,"B");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        List<Integer> yang = users.stream()
                .peek(it -> it.setName("yang"))
                .map(User::getAge)
                .collect(Collectors.toList());
    }
}
