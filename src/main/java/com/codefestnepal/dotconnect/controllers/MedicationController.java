package com.codefestnepal.dotconnect.controllers;

import com.codefestnepal.dotconnect.dtos.MedicationDto;
import com.codefestnepal.dotconnect.services.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/medication-information")

public class MedicationController extends BaseController {
    @Autowired
    private MedicationService medicationService;
    @GetMapping
    public List<MedicationDto> get(String patientId) {
        return medicationService.get(patientId,getAgencyId(),getAgencyName());

    }
    @PostMapping
    public  void save( @RequestBody MedicationDto medicationDto){
        medicationDto.setId(java.util.UUID.randomUUID().toString());
        medicationDto.setHospitalId(getAgencyId());
        medicationDto.setHospitalName(getAgencyName());
        medicationService.save(medicationDto);
    }
}
