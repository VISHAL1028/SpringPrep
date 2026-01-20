package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        Alien a1 = (Alien) context.getBean("alien");
        Alien a2 = (Alien) context.getBean("alien");

        System.out.println(a1);
        System.out.println(a2);
    }
}
