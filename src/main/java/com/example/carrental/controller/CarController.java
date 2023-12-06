package com.example.carrental.controller;

import com.example.carrental.dto.CarCreateDto;
import com.example.carrental.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/create-car")
    public String createCarView() {
        return "car/create-car";
    }



    @PostMapping("/create-car")
    public String createCar(@ModelAttribute CarCreateDto carCreateDto, Principal principal){
        carService.create(carCreateDto, principal);
        return "redirect:/";
    }


    @GetMapping("/")
    public String getCars(
            @RequestParam(value = "startDate", required = false) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) LocalDate endDate) {

        return "index";
    }

    @GetMapping("/car/{id}")
    public String getCar(@PathVariable("id") Integer carId){
        return "car/car-info";
    }

    @PutMapping("/{id}")
    public String updateCar(@PathVariable("id") Integer carId){
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable("id") Integer carId){
        return "redirect:/";
    }
    

} 
