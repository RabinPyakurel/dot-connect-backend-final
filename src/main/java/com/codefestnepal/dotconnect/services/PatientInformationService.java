package com.codefestnepal.dotconnect.services;

import com.codefestnepal.dotconnect.dtos.PatientInformationDto;
import com.codefestnepal.dotconnect.models.PatientInformation;
import com.codefestnepal.dotconnect.repositories.PatientInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PatientInformationService {
    @Autowired
    private PatientInformationRepository patientInformationRepository;

    public Optional<PatientInformationDto> get(String lastName, int  birthYear, String citizenshipNumber) {
        var list = patientInformationRepository.findAll();
        Optional<PatientInformation> patientInformationOptional = list.stream()
                .filter(document -> document.getLastName().equalsIgnoreCase(lastName)
                        && document.getCitizenshipNumber().equalsIgnoreCase(citizenshipNumber)
                        && document.getDateOfBirth().getYear() == birthYear).findFirst();
        if (patientInformationOptional.isPresent()) {
            PatientInformation patientInformation = patientInformationOptional.get();
            PatientInformationDto patientInformationDto = new PatientInformationDto();
            patientInformationDto.setPatientId(patientInformation.getPatientId());
            patientInformationDto.setFirstName(patientInformation.getFirstName());
            patientInformationDto.setLastName(patientInformation.getLastName());
            patientInformationDto.setGender(patientInformation.getGender());
            patientInformationDto.setCitizenshipNumber(patientInformation.getCitizenshipNumber());
            patientInformationDto.setDateOfBirth(patientInformation.getDateOfBirth());
            patientInformationDto.setBloodGroup(patientInformation.getBloodGroup());
            patientInformationDto.setPhoneNumber(patientInformation.getPhoneNumber());
            return Optional.of(patientInformationDto);
        }

        return Optional.empty();
    }

    public void save(PatientInformationDto patientInformationDto) {
        PatientInformation patientInformation = new PatientInformation();
        patientInformation.setPatientId(patientInformationDto.getPatientId());
        patientInformation.setFirstName(patientInformationDto.getFirstName());
        patientInformation.setLastName(patientInformationDto.getLastName());
        patientInformation.setGender(patientInformationDto.getGender());
        patientInformation.setCitizenshipNumber(patientInformationDto.getCitizenshipNumber());
        patientInformation.setDateOfBirth(patientInformationDto.getDateOfBirth());
        patientInformation.setBloodGroup(patientInformationDto.getBloodGroup());
        patientInformation.setPhoneNumber(patientInformationDto.getPhoneNumber());
        patientInformationRepository.save(patientInformation);

    }
}
