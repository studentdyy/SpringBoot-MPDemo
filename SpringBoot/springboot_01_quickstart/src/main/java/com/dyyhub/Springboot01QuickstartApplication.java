package com.dyyhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot01QuickstartApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(Springboot01QuickstartApplication.class);
        Object datasource = run.getBean("datasource");
        System.out.println(datasource);
    }

}
