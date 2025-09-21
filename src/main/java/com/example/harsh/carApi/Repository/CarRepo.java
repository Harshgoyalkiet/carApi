package com.example.harsh.carApi.Repository;

import com.example.harsh.carApi.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Integer> {
}
