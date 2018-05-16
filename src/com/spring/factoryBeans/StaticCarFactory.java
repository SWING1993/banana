package com.spring.factoryBeans;


import com.spring.beans.Car;

import java.util.HashMap;
import java.util.Map;

//静态工厂方法
public class StaticCarFactory {

    private static Map<String,Car> cars = new HashMap<String,Car>();

    static {
        cars.put("audi", new Car("audi","12", 1230));
        cars.put("ford", new Car("ford","44", 5567));

    }
    public static Car getCar(String name) {
        return cars.get(name);
    }

}
