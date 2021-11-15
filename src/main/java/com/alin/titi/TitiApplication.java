package com.alin.titi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication()
@CrossOrigin(value = "http://163.17.136.180:8080")
public class TitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TitiApplication.class, args);
    }

}
