package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    private final CarRepository carRepository;

    private final OwnerRepository ownerRepository;

    private final UserRepository userRepository;

    public CardatabaseApplication(CarRepository carRepository, OwnerRepository ownerRepository, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        // After adding this comment the application is restarted
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("Hello Spring Boot");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            // Add owner objects and save these to db
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Robinson");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            // Add car object with link to owners and save these to db.
            Car car = new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000, owner1);
            carRepository.save(car);
            car = new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, owner2);
            carRepository.save(car);
            car = new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, owner2);
            carRepository.save(car);


            // username: user password: user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));
            // username: admin password: admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));
        };
    }
}
