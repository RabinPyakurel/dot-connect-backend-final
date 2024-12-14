package com.codefestnepal.dotconnect.services;

import com.codefestnepal.dotconnect.dtos.CheckUpInformationDto;
import com.codefestnepal.dotconnect.models.ActivityLog;
import com.codefestnepal.dotconnect.models.CheckUpInformation;
import com.codefestnepal.dotconnect.repositories.ActivityLogRepository;
import com.codefestnepal.dotconnect.repositories.CheckUpInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckUpInformationService {
    @Autowired
    private CheckUpInformationRepository checkUpInformationRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;

    public List<CheckUpInformationDto> getall(String patientId ,String agencyId ,String agencyName){
        List<CheckUpInformation> checkUpInformationList = checkUpInformationRepository.findAllByPatientIdOrderByDateVisitedDesc(patientId);

        List<CheckUpInformationDto> checkUpInformationDtoList = new ArrayList<>();


        for (CheckUpInformation checkUpInformation : checkUpInformationList) {
            CheckUpInformationDto checkUpInformationDto = new CheckUpInformationDto();
            checkUpInformationDto.setId(checkUpInformation.getId());
            checkUpInformationDto.setDateVisited(checkUpInformation.getDateVisited());
            checkUpInformationDto.setHospitalId(checkUpInformation.getHospitalId());
            checkUpInformationDto.setFollowUpDate(checkUpInformation.getFollowUpDate());
            checkUpInformationDto.setPatientId(checkUpInformation.getPatientId());
            checkUpInformationDto.setReason(checkUpInformation.getReason());
            checkUpInformationDto.setHospitalName(checkUpInformation.getHospitalName());
            checkUpInformationDtoList.add(checkUpInformationDto);

        }
        ActivityLog log = new ActivityLog();
        log.setPatientId(patientId);
        log.setAgencyId(agencyId);
        log.setAgencyName(agencyName);
        log.setDateTime(LocalDate.now());
        log.setType("Viewed check up information");
        activityLogRepository.save(log);

        return checkUpInformationDtoList;
    }
    public  void save(CheckUpInformationDto checkUpInformationDto) {
        CheckUpInformation checkUpInformation = new CheckUpInformation();
        checkUpInformation.setDateVisited(checkUpInformationDto.getDateVisited());
        checkUpInformation.setHospitalId(checkUpInformationDto.getHospitalId());
        checkUpInformation.setFollowUpDate(checkUpInformationDto.getFollowUpDate());
        checkUpInformation.setPatientId(checkUpInformationDto.getPatientId());
        checkUpInformation.setReason(checkUpInformationDto.getReason());
        checkUpInformation.setHospitalName(checkUpInformationDto.getHospitalName());
        checkUpInformationRepository.save(checkUpInformation);
        ActivityLog log = new ActivityLog();
        log.setPatientId(checkUpInformationDto.getPatientId());
        log.setAgencyId(checkUpInformationDto.getHospitalId());
        log.setAgencyName(checkUpInformationDto.getHospitalName());
        log.setDateTime(LocalDate.now());
        log.setType("Saved check up information");
        activityLogRepository.save(log);
    }
}

