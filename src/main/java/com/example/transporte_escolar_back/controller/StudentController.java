package com.example.transporte_escolar_back.controller;

import com.example.transporte_escolar_back.dto.request.RegisterStudentRequest;
import com.example.transporte_escolar_back.dto.response.RegisterStudentResponse;
import com.example.transporte_escolar_back.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping()
    public ResponseEntity<RegisterStudentResponse> registerStudent(@RequestBody RegisterStudentRequest request){
        RegisterStudentResponse response = studentService.register(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
