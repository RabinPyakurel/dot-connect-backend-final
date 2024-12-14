package com.codefestnepal.dotconnect.controllers;

import com.codefestnepal.dotconnect.dtos.DiagnosisInformationDto;
import com.codefestnepal.dotconnect.models.DiagnosisInformation;
import com.codefestnepal.dotconnect.repositories.DiagnosisInformationRepository;
import com.codefestnepal.dotconnect.services.DiagnosisInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/diagonosis-informatiob")
public class DiagnosisInformationController extends BaseController {
    @Autowired
    private DiagnosisInformationService diagnosisInformationService;
    @GetMapping
    public List<DiagnosisInformationDto> get(String patientId) {
        return diagnosisInformationService.get(patientId,getAgencyId(),getAgencyName());

    }
    @PostMapping
    public void save( @RequestBody DiagnosisInformationDto diagnosisInformationDto){
        diagnosisInformationDto.setId(java.util.UUID.randomUUID().toString());
        diagnosisInformationDto.setHospitalId(getAgencyId());
        diagnosisInformationDto.setHospitalName(getAgencyName());
        diagnosisInformationService.save(diagnosisInformationDto);

    }
}
