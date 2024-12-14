package com.codefestnepal.dotconnect.services;

import com.codefestnepal.dotconnect.dtos.DiagnosisInformationDto;
import com.codefestnepal.dotconnect.models.ActivityLog;
import com.codefestnepal.dotconnect.models.DiagnosisInformation;
import com.codefestnepal.dotconnect.repositories.ActivityLogRepository;
import com.codefestnepal.dotconnect.repositories.DiagnosisInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiagnosisInformationService {
    @Autowired
    private DiagnosisInformationRepository diagnosisInformationRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;
        public List<DiagnosisInformationDto> get(String patientId ,String agencyId , String agencyName ){
        List<DiagnosisInformation> diagnosisInformations = diagnosisInformationRepository.findAllByPatientIdOrderByDateDesc(patientId);
            List<DiagnosisInformationDto> diagnosisInformationsDtoList = new ArrayList<>();

        for (DiagnosisInformation diagnosisInformation : diagnosisInformations) {
            DiagnosisInformationDto diagnosisInformationDto = new DiagnosisInformationDto();
                diagnosisInformationDto.setId(diagnosisInformation.getId());
                diagnosisInformationDto.setPatientId(diagnosisInformation.getPatientId());
                diagnosisInformationDto.setHospitalId(diagnosisInformation.getHospitalId());
                diagnosisInformationDto.setDate(diagnosisInformation.getDate());
                diagnosisInformationDto.setDiagnosisName(diagnosisInformation.getDiagnosisName());
                diagnosisInformationDto.setResult(diagnosisInformation.getResult());
                diagnosisInformationDto.setHospitalName(diagnosisInformation.getHospitalName());
            diagnosisInformationsDtoList.add(diagnosisInformationDto);



        }
            ActivityLog log = new ActivityLog();
            log.setPatientId(patientId);
            log.setAgencyId(agencyId);
            log.setAgencyName(agencyName);
            log.setDateTime(LocalDate.now());
            log.setType("Viewed Diagnosis information");
            activityLogRepository.save(log);
        return diagnosisInformationsDtoList;
    }
    public void save (DiagnosisInformationDto diagnosisInformationDto){
        DiagnosisInformation diagnosisInformation = new DiagnosisInformation();
                diagnosisInformation.setPatientId(diagnosisInformationDto.getPatientId());
                diagnosisInformation.setHospitalId(diagnosisInformationDto.getHospitalId());
                diagnosisInformation.setDiagnosisName(diagnosisInformationDto.getDiagnosisName());
                diagnosisInformation.setResult(diagnosisInformationDto.getResult());
                diagnosisInformation.setHospitalName(diagnosisInformationDto.getHospitalName());
                diagnosisInformation.setDate(diagnosisInformationDto.getDate());
                diagnosisInformationRepository.save(diagnosisInformation);
        ActivityLog log = new ActivityLog();
        log.setPatientId(diagnosisInformationDto.getPatientId());
        log.setAgencyId(diagnosisInformationDto.getHospitalId());
        log.setAgencyName(diagnosisInformationDto.getHospitalName());
        log.setDateTime(LocalDate.now());
        log.setType("Saved Diagnosis information");
        activityLogRepository.save(log);
    }
}
