package com.codefestnepal.dotconnect.controllers;

import com.codefestnepal.dotconnect.dtos.PatientInformationDto;
import com.codefestnepal.dotconnect.services.PatientInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient-information")
public class  PatientInformationController extends BaseController {
    @Autowired
    private PatientInformationService patientInformationService;

    @GetMapping
    public ResponseEntity<?> get(String lastName, int birthYear, String citizenshipNumber ) {

        Optional<PatientInformationDto> dto = patientInformationService.get(lastName, birthYear, citizenshipNumber);
        if (dto.isPresent()) {
            return ResponseEntity.ok(dto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public void save(@RequestBody PatientInformationDto patientInformationDto) {
        patientInformationDto.setPatientId(java.util.UUID.randomUUID().toString());
        patientInformationService.save(patientInformationDto);
    }

}
