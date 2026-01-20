package org.example;

import org.example.service.ReportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    static void main() {

        System.out.println("helllo");
//        IOC Started
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
       ReportService service= context.getBean(ReportService.class);
        service.generateReport();
    }
}
