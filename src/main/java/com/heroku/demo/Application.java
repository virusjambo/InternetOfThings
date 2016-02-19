package com.heroku.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.heroku" })
@EntityScan(basePackages="com.heroku")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
