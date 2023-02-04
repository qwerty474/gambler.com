package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Controller {
    public String getGreeting() {
        return "Hello Spring!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Controller.class, args);
		System.out.println(new Controller().getGreeting());
    }

}
