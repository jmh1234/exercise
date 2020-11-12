package com.github.hcsp.ioc;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class MyIoCContainer {

    private Properties properties = new Properties();
    private static Map<String, Object> beansMap = new HashMap<>();

    // 实现一个简单的IoC容器，使得：
    // 1. 从beans.properties里加载bean定义
    // 2. 自动扫描bean中的@Autowired注解并完成依赖注入
    public static void main(String[] args) {
        MyIoCContainer container = new MyIoCContainer();
        container.start();
        OrderService orderService = (OrderService) container.getBean("orderService");
        orderService.createOrder();
    }

    public MyIoCContainer() {
        try {
            properties.load(MyIoCContainer.class.getResourceAsStream("/beans.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 启动该容器
    public void start() {
        properties.forEach(MyIoCContainer::addInstance2BeansMap);
        beansMap.forEach((beanName, beanInstance) -> dependencyInject(beanInstance));
    }

    private void dependencyInject(Object beanInstance) {
        List<Field> dependencyField = Arrays.stream(beanInstance.getClass().getDeclaredFields())
                .filter(field -> field.getAnnotation(Autowired.class) != null)
                .collect(Collectors.toList());
        dependencyField.forEach(field -> addDependency4Bean(field, beanInstance));
    }

    private void addDependency4Bean(Field field, Object beanInstance) {
        field.setAccessible(true);
        String dependencyFieldName = field.getName();
        Object dependencyField = beansMap.get(dependencyFieldName);
        try {
            field.set(beanInstance, dependencyField);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void addInstance2BeansMap(Object beanName, Object beanClass) {
        try {
            Class<?> aClass = Class.forName((String) beanClass);
            Object beanInstance = aClass.getConstructor().newInstance();
            beansMap.put((String) beanName, beanInstance);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    // 从容器中获取一个bean
    public Object getBean(String beanName) {
        return beansMap.get(beanName);
    }
}
