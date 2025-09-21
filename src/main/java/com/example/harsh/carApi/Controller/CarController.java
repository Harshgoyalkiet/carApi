package com.example.harsh.carApi.Controller;

import com.example.harsh.carApi.Model.Car;
import com.example.harsh.carApi.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/getAllData")
    public ResponseEntity<Object> getAllData() {
        return CarService.getAllData();
    }

    @GetMapping("/getData{id}")
    public ResponseEntity<Object> getData(@PathVariable int id) {
        return CarService.getData(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addData(@RequestBody Car car) {
        if (car.getModel()== "") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return CarService.addData(car);
    }

    @PutMapping("/update{id}")
    public ResponseEntity<Object> updateDate(@PathVariable int id, @RequestBody Car car) {
        if(car.getPrice()==0)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No data provided");
        }
        return CarService.updateData(id,car.getPrice());
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {

        return CarService.deleteData(id);
    }


}
