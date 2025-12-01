package com.example.transporte_escolar_back.service;

import com.example.transporte_escolar_back.dto.request.RegisterStudentRequest;
import com.example.transporte_escolar_back.dto.response.RegisterStudentResponse;
import com.example.transporte_escolar_back.exceptions.DriverNotFoundException;
import com.example.transporte_escolar_back.model.Address;
import com.example.transporte_escolar_back.model.Responsible;
import com.example.transporte_escolar_back.model.School;
import com.example.transporte_escolar_back.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    public RegisterStudentResponse register(RegisterStudentRequest request){

        Student student = Student.builder()
                .name(request.name())
                .birthDate(request.birthDate())
                .cpf(request.cpf())
                .studentDepartureTime(request.studentDepartureTime())
                .studentArrivalTime(request.studentArrivalTime())
                .build();

//        Address studentAddress = Address.builder()
//                .cep(request.studentAddress().getCep())
//                .street(request.studentAddress().getStreet())
//                .number(request.studentAddress().getNumber())
//                .neighborhood(request.studentAddress().getNeighborhood())
//                .city(request.studentAddress().getCity())
//                .state(request.studentAddress().getState())
//                .build();
//
//        School studentSchool = School.builder()
//                .name(request.studentSchool().getName())
//                .build();
//
//        Address schoolAddress = Address.builder()
//                .cep(request.studentSchool().getSchoolAddress().getCep())
//                .street(request.studentSchool().getSchoolAddress().getStreet())
//                .number(request.studentSchool().getSchoolAddress().getNumber())
//                .neighborhood(request.studentSchool().getSchoolAddress().getNeighborhood())
//                .city(request.studentSchool().getSchoolAddress().getCity())
//                .state(request.studentSchool().getSchoolAddress().getState())
//                .build();
//
//        Responsible studentResponsible = Responsible.builder()
//                .name(request.studentResponsible().getName())
//                .kinship(request.studentResponsible().getKinship())
//                .contactNumber(request.studentResponsible().getContactNumber())
//                .build();

        try{
            return new RegisterStudentResponse(true, "Student saved", student);
        } catch (Exception e){
            if (e instanceof DriverNotFoundException) {
                throw e;
            }
            throw new RuntimeException("Internal error", e);
        }
    }
}

//Driver driver = Driver.builder()
//        .name(request.name())
//        .telephone(request.telephone())
//        .cnh(request.cnh())
//        .vehiclePlate(request.vehiclePlate())
//        .build();
//            driverRepository.save(driver);