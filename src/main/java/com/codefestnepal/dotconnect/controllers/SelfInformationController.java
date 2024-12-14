package com.codefestnepal.dotconnect.controllers;

import com.codefestnepal.dotconnect.dtos.CheckUpInformationDto;
import com.codefestnepal.dotconnect.dtos.PatientInformationDto;
import com.codefestnepal.dotconnect.dtos.SelfInformationDto;
import com.codefestnepal.dotconnect.services.SelfInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/self-information")
public class SelfInformationController {
    @Autowired
    private SelfInformationService selfInformationService;
    @GetMapping
    public ResponseEntity<?> get(String citizenshipNumber ) {

        Optional<SelfInformationDto> dto = selfInformationService.get(citizenshipNumber);
        if (dto.isPresent()) {
            return ResponseEntity.ok(dto.get());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/test")
    public SelfInformationDto test(){
        return new SelfInformationDto();
    }

}
