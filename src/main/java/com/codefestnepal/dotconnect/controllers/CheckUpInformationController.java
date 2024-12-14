package com.codefestnepal.dotconnect.controllers;

import com.codefestnepal.dotconnect.dtos.CheckUpInformationDto;
import com.codefestnepal.dotconnect.services.CheckUpInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkup-information")

public class  CheckUpInformationController extends BaseController {
    @Autowired
    private CheckUpInformationService checkUpInformationService;


    @GetMapping
    public List<CheckUpInformationDto> getall(String patientId){
        return checkUpInformationService.getall(patientId,getAgencyId(),getAgencyName());


    }

    @PostMapping
    public void save( @RequestBody CheckUpInformationDto checkUpInformationDto){
        checkUpInformationDto.setId(java.util.UUID.randomUUID().toString());
        checkUpInformationDto.setHospitalId(getAgencyId());
        checkUpInformationDto.setHospitalName(getAgencyName());
        checkUpInformationService.save(checkUpInformationDto);

    }

}
