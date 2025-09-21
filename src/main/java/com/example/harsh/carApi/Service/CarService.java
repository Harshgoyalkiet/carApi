package com.example.harsh.carApi.Service;

import com.example.harsh.carApi.Model.Car;
import com.example.harsh.carApi.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private static CarRepo carRepo;


    public static ResponseEntity<Object> getAllData() {
        List<Car> carList = carRepo.findAll();
        if (carList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No data Available");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carList);
    }

    public static ResponseEntity<Object> getData(int id) {
        Optional<Car> carData = carRepo.findById(id);
        if (carData.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
        Car caar = carData.get();
        return ResponseEntity.status(HttpStatus.OK).body(caar);
    }

    public static ResponseEntity<Object> addData(Car car) {
        try {
            Car newCar = new Car(car.getId(), car.getModel(), car.getManufactureYear(), car.getCompanyName(), car.getModelType(), car.getPrice(), car.getFuelType(), car.getSeatingCapacity());
            carRepo.save(newCar);
            return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    public static ResponseEntity<Object> updateData(int id, double price) {
        Optional<Car> carData = carRepo.findById(id);
        if (carData.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        Car caar = carData.get();
        caar.setPrice(price);
        carRepo.save(caar);
        return ResponseEntity.status(HttpStatus.OK).body(caar);
    }

    public static ResponseEntity<Object> deleteData(int id) {
        Optional<Car> carData = carRepo.findById(id);
        if (carData.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
        carRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }


}
