package com.example.transporte_escolar_back.controller;

import com.example.transporte_escolar_back.dto.request.RegisterDriverRequest;
import com.example.transporte_escolar_back.dto.request.UpdateDriverRequest;
import com.example.transporte_escolar_back.dto.response.ConsultDriverResponse;
import com.example.transporte_escolar_back.dto.response.DeleteDriverResponse;
import com.example.transporte_escolar_back.dto.response.RegisterDriverResponse;
import com.example.transporte_escolar_back.dto.response.UpdateDriverResponse;
import com.example.transporte_escolar_back.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @PostMapping()
    public ResponseEntity<RegisterDriverResponse> registerDriver(@RequestBody RegisterDriverRequest request){
        RegisterDriverResponse response = driverService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{cnh}")
    public ResponseEntity<DeleteDriverResponse> deleteDriver(@PathVariable String cnh){
        DeleteDriverResponse response = driverService.delete(cnh);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{cnh}")
    public ResponseEntity<ConsultDriverResponse> consultDriver(@PathVariable String cnh){
        ConsultDriverResponse response = driverService.consult(cnh);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{cnh}")
    public ResponseEntity<UpdateDriverResponse> updateDriver(@PathVariable String cnh, @RequestBody UpdateDriverRequest request){
        UpdateDriverResponse response = driverService.update(cnh, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
