package com.young.libdemo.fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.young.libdemo.vo.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yzx
 * @date: 2018/8/21
 * @description: For ali FastJson test
 */
public class FastJsonDemo {


    /**
     * Json-str --> JSONObject
     * 获取json字符串属性参数
     * 如果没有此参数则返回null
     *
     * json-str --> JavaBean
     * 类型转换
     */
    @Test
    public void test01() {
        String jsonStr = "{\"name\":\"yzx\",\"age\":18}";
        Integer age = JSON.parseObject(jsonStr).getInteger("age");
        String name = JSON.parseObject(jsonStr).getString("name");
        System.out.println("name:"+name+"age:"+age);

        //map
        Map<String, Object> map = new HashMap<>();
        map.put("name", "v1");
        map.put("age",18);
        map.put("type", "v3");
        String mapJsonStr = JSON.toJSONString(map);
        User user = JSONObject.parseObject(mapJsonStr, User.class);
        System.out.println(user);
    }

    @Test
    public void test02() {
        User user = new User();
        user.setType("1");
        user.setName("yzx");
        System.out.println(JSONObject.toJSONString(user));
    }

}



