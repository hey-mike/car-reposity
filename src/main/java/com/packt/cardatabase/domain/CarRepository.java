package com.packt.cardatabase.domain;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository <Car, Long> {
    // Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByYearAsc(String brand);
}