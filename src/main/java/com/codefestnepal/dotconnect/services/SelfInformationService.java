package com.codefestnepal.dotconnect.services;

import com.codefestnepal.dotconnect.dtos.*;
import com.codefestnepal.dotconnect.models.*;
import com.codefestnepal.dotconnect.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class SelfInformationService {
    @Autowired
    private PatientInformationRepository patientInformationRepository;
    @Autowired
    private DiagnosisInformationRepository diagnosisInformationRepository;
    @Autowired
    private MedicationRepository medicationRepository;
    @Autowired
    private CheckUpInformationRepository checkUpInformationRepository;
    @Autowired
    private ActivityLogRepository activityLogRepository;

    public Optional<SelfInformationDto> get(String citizenshipNumber) {
     Optional<PatientInformation> patientInformationOpt = patientInformationRepository.findByCitizenshipNumberIgnoreCase(citizenshipNumber);
     if (patientInformationOpt.isPresent()) {
         PatientInformation patientInformation = patientInformationOpt.get();
         SelfInformationDto selfInformationDto = new SelfInformationDto();
         selfInformationDto.setPatientId(patientInformation.getPatientId());
         selfInformationDto.setFirstName(patientInformation.getFirstName());
         selfInformationDto.setLastName(patientInformation.getLastName());
         selfInformationDto.setGender(patientInformation.getGender());
         selfInformationDto.setCitizenshipNumber(patientInformation.getCitizenshipNumber());
         selfInformationDto.setDateOfBirth(patientInformation.getDateOfBirth());
         selfInformationDto.setBloodGroup(patientInformation.getBloodGroup());
         selfInformationDto.setPhoneNumber(patientInformation.getPhoneNumber());
         var medicationsList = medicationRepository.findAllByPatientIdOrderByDateDesc(patientInformation.getPatientId());
         java.util.List<MedicationDto> medicationDtoList = new ArrayList<>();

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
         selfInformationDto.setMedications(medicationDtoList);
         var checkUpInformationList = checkUpInformationRepository.findAllByPatientIdOrderByDateVisitedDesc(patientInformation.getPatientId());
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
         selfInformationDto.setCheckups(checkUpInformationDtoList);
         var diagnosisInformations = diagnosisInformationRepository.findAllByPatientIdOrderByDateDesc(patientInformation.getPatientId());
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
         selfInformationDto.setDiagnoses(diagnosisInformationsDtoList);
         List<ActivityLog> activityLogs = activityLogRepository.findAllByPatientIdOrderByDateTimeDesc(patientInformation.getPatientId());
         List<ActivityLogDto> activityLogDtoList = new ArrayList<>();
         for (ActivityLog activityLog : activityLogs) {
             ActivityLogDto activityLogDto = new ActivityLogDto();
             activityLogDto.setId(activityLog.getId());
             activityLogDto.setPatientId(activityLog.getPatientId());
             activityLogDto.setAgencyName(activityLog.getAgencyName());
             activityLogDto.setAgencyId(activityLog.getAgencyId());
             activityLogDto.setDateTime(activityLog.getDateTime());
             activityLogDto.setType(activityLog.getType());
             activityLogDtoList.add(activityLogDto);



         }
         selfInformationDto.setActivityLogs(activityLogDtoList);

         return Optional.of(selfInformationDto);
     }
     return Optional.empty();
    }
}
