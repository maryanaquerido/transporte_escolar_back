package com.example.transporte_escolar_back.service;

import com.example.transporte_escolar_back.dto.request.RegisterDriverRequest;
import com.example.transporte_escolar_back.dto.request.UpdateDriverRequest;
import com.example.transporte_escolar_back.dto.response.*;
import com.example.transporte_escolar_back.exceptions.DriverIsRegisteredException;
import com.example.transporte_escolar_back.exceptions.DriverNotFoundException;
import com.example.transporte_escolar_back.model.Driver;
import com.example.transporte_escolar_back.repository.DriverRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    @Transactional
    public ConsultAllDriverResponse consultDriverOrdered(){
        try{
            List<Driver> result = driverRepository.consultDriverOrdered();

            if (result == null || result.isEmpty()) {
                return new ConsultAllDriverResponse(false,"No drivers found",List.of());
            }

            List<DriverResponse> drivers = result.stream()
                    .map(d -> new DriverResponse(
                            d.getIdDriver(),
                            d.getName(),
                            d.getTelephone(),
                            d.getCnh(),
                            d.getVehiclePlate()
                    )).toList();
            return new ConsultAllDriverResponse(true, "Drivers found",drivers);
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public RegisterDriverResponse registerByProcedure(RegisterDriverRequest request){
        try{
            if(driverRepository.existsByCnh(request.cnh())){
                throw new DriverIsRegisteredException("Driver already registered");
            }
            Driver driver = Driver.builder()
                    .name(request.name())
                    .telephone(request.telephone())
                    .cnh(request.cnh())
                    .vehiclePlate(request.vehiclePlate())
                    .build();
            driverRepository.insertDriver(
                    driver.getName(),
                    driver.getTelephone(),
                    driver.getCnh(),
                    driver.getVehiclePlate()
            );
            return new RegisterDriverResponse(true, "Driver saved",driver);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public RegisterDriverResponse register(RegisterDriverRequest request){
        try{
            if(driverRepository.existsByCnh(request.cnh())){
                throw new DriverIsRegisteredException("Driver already registered");
            }
            Driver driver = Driver.builder()
                    .name(request.name())
                    .telephone(request.telephone())
                    .cnh(request.cnh())
                    .vehiclePlate(request.vehiclePlate())
                    .build();
            driverRepository.save(driver);
            return new RegisterDriverResponse(true, "Driver saved",driver);
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
    public DeleteDriverResponse delete(String cnh){
        try {
            Optional<Driver> driver = driverRepository.findByCnh(cnh);
            if (driver.isEmpty()) {
                throw new DriverNotFoundException("Driver not found");//404
            } else {
                driverRepository.delete(driver.get());
                return new DeleteDriverResponse(true, "Driver deleted");//200
            }
        } catch (Exception e){
            throw new RuntimeException();//500
        }
    }
    public ConsultDriverResponse consult(String cnh) {
        if (cnh == null || cnh.isBlank()) {
            throw new IllegalArgumentException("CNH is required");
        }
        try {
            Driver driver = driverRepository.findByCnh(cnh)
                    .orElseThrow(() -> new DriverNotFoundException("Driver not found"));
            return new ConsultDriverResponse(true, "Driver found", driver);
        } catch (Exception e) {
            if (e instanceof DriverNotFoundException) {
                throw e;
            }
            throw new RuntimeException("Internal error", e);
        }
    }
    public UpdateDriverResponse update(String cnh, UpdateDriverRequest request) {

        if (cnh == null || cnh.isBlank()) {
            throw new IllegalArgumentException("CNH is required");
        }

        try {
            Driver existingDriver = driverRepository.findByCnh(cnh)
                    .orElseThrow(() -> new DriverNotFoundException("Driver not found"));

            existingDriver.setName(request.name());
            existingDriver.setTelephone(request.telephone());
            existingDriver.setVehiclePlate(request.vehiclePlate());

            Driver updatedDriver = driverRepository.save(existingDriver);

            return new UpdateDriverResponse(true, "Driver updated", updatedDriver);
        } catch (Exception e) {
            if (e instanceof DriverNotFoundException) {
                throw e;
            }
            throw new RuntimeException("Internal error", e);
        }
    }
}
