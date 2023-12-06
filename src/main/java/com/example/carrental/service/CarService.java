package com.example.carrental.service;

import com.example.carrental.dto.CarCreateDto;
import com.example.carrental.entity.Car;
import com.example.carrental.entity.User;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class CarService

{

    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    @Transactional
    public void create(CarCreateDto carCreateDto, Principal principal) {
        Car car = modelMapper.map(carCreateDto, Car.class);
        User user = userRepository.findUserByEmail(principal.getName()).get();

        car.setUser(user);
        carRepository.save(car);
    }
}
