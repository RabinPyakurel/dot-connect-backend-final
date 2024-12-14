package com.codefestnepal.dotconnect.services;

import com.codefestnepal.dotconnect.dtos.MedicationDto;
import com.codefestnepal.dotconnect.models.ActivityLog;
import com.codefestnepal.dotconnect.models.Medication;
import com.codefestnepal.dotconnect.repositories.ActivityLogRepository;
import com.codefestnepal.dotconnect.repositories.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class MedicationService {
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;

    public List<MedicationDto> get( String patientId,String agencyId,String agencyName) {
        List<Medication> medicationsList = medicationRepository.findAllByPatientIdOrderByDateDesc(patientId);
        List<MedicationDto> medicationDtoList = new ArrayList<>();

        for (Medication medication : medicationsList) {
            MedicationDto medicationDto = new MedicationDto();
            medicationDto.setMedicineName(medication.getMedicineName());
            medicationDto.setPatientId(medication.getPatientId());
            medicationDto.setDate(medication.getDate());
            medicationDto.setFrequency(medication.getFrequency());
            medicationDto.setHospitalId(medication.getHospitalId());
            medicationDto.setId(medication.getId());
            medicationDto.setHospitalName(medication.getHospitalName());
            medicationDtoList.add(medicationDto);
        }
        ActivityLog log = new ActivityLog();
        log.setPatientId(patientId);
        log.setAgencyId(agencyId);
        log.setAgencyName(agencyName);
        log.setDateTime(LocalDate.now());
        log.setType("Viewed Medication information");
        activityLogRepository.save(log);
        return medicationDtoList;

    }
    public void save(MedicationDto medicationDto) {
        Medication medication = new Medication();
        medication.setMedicineName(medicationDto.getMedicineName());
        medication.setPatientId(medicationDto.getPatientId());
        medication.setId(medicationDto.getId());
        medication.setDate(medicationDto.getDate());
        medication.setFrequency(medicationDto.getFrequency());
        medication.setHospitalId(medicationDto.getHospitalId());
        medication.setHospitalName(medicationDto.getHospitalName());
        medicationRepository.save(medication);
        ActivityLog log = new ActivityLog();
        log.setPatientId(medicationDto.getPatientId());
        log.setAgencyId(medicationDto.getHospitalId());
        log.setAgencyName(medicationDto.getHospitalName());
        log.setDateTime(LocalDate.now());
        log.setType("Saved Medication information");
        activityLogRepository.save(log);
    }
}
