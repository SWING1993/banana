package com.spring.factoryBeans;

import com.spring.beans.Car;

import java.util.HashMap;
import java.util.Map;


// 实例工厂的方法
public class InstanceCarFactory {

    private Map<String,Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<String, Car>();
        cars.put("audi", new Car("audi","12", 1230));
        cars.put("ford", new Car("ford","44", 5567));
    }

    public Car getCar(String name) {
        return cars.get(name);
    }
}
