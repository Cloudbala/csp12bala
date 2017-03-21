package com.equinix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Java8PocApplication {

    public static boolean isGreenApple(Apple apple) {
        return "GREEN".equals(apple.getColor());
    }

    public interface Inter<T> {
        boolean test(T t);
    }

    private static List<Apple> filterApples(List<Apple> inventory, Inter<Apple> app) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (app.test(apple)) {
                result.add(apple);
            }
        }
        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(Java8PocApplication.class, args);

        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        //Apple a4 = new Apple();

        a1.setColor("RED");
        a2.setColor("GREEN");
        a3.setColor("ORANGE");
      //  a4.setColor("GREEN");

        List<Apple> app = new ArrayList<>();
        app.add(a1);
        app.add(a2);
        app.add(a3);
       // app.add(a4);

        //filterApples(app, Apple::isGreenApple);
        List<Apple> apples = filterApples(app, (Apple a) -> "GREEN".equals(a.getColor()));
        System.out.println("apples = " + apples);
    }

}
