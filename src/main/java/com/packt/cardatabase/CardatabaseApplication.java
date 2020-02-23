package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
    @Autowired
    private CarRepository repository;

    public static void main(String[] args) {
        // After adding this comment the application is restarted
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("Hello Spring Boot");
    }
    @Bean
    CommandLineRunner runner(){
        return args -> {
            // Save demo data to database
            repository.save(new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000));
            repository.save(new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000));
            repository.save(new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000));
        };
    }
}
