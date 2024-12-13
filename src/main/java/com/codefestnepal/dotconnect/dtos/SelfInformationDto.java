package com.codefestnepal.dotconnect.dtos;

import java.time.LocalDate;
import java.util.List;

public class SelfInformationDto {
    private String patientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String citizenshipNumber;
    private String bloodGroup;
    private List<CheckUpInformationDto> checkups;
    private List<DiagnosisInformationDto> diagnoses;
    private List<MedicationDto> medications;
    private List<ActivityLogDto> activityLogs;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public void setCitizenshipNumber(String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<CheckUpInformationDto> getCheckups() {
        return checkups;
    }

    public void setCheckups(List<CheckUpInformationDto> checkups) {
        this.checkups = checkups;
    }

    public List<DiagnosisInformationDto> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<DiagnosisInformationDto> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<MedicationDto> getMedications() {
        return medications;
    }

    public void setMedications(List<MedicationDto> medications) {
        this.medications = medications;
    }

    public List<ActivityLogDto> getActivityLogs() {
        return activityLogs;
    }

    public void setActivityLogs(List<ActivityLogDto> activityLogs) {
        this.activityLogs = activityLogs;
    }
}
