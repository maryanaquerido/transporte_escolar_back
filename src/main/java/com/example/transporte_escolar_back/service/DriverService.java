package com.example.transporte_escolar_back.service;

import com.example.transporte_escolar_back.dto.request.RegisterDriverRequest;
import com.example.transporte_escolar_back.dto.response.ConsultDriverResponse;
import com.example.transporte_escolar_back.dto.response.DeleteDriverResponse;
import com.example.transporte_escolar_back.dto.response.RegisterDriverResponse;
import com.example.transporte_escolar_back.exceptions.DriverIsRegisteredException;
import com.example.transporte_escolar_back.exceptions.DriverNotFoundException;
import com.example.transporte_escolar_back.model.Driver;
import com.example.transporte_escolar_back.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

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
    public ConsultDriverResponse consult(String cnh){
        try{
            Optional<Driver> driver = driverRepository.findByCnh(cnh);
            if(driver.isEmpty()){
                throw new DriverNotFoundException("Driver not found");
            }
            return new ConsultDriverResponse(true, "Driver found", driver);
        } catch (Exception e){
            throw new RuntimeException();//500
        }
    }
}
