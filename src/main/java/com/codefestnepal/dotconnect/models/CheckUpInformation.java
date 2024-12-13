package com.codefestnepal.dotconnect.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Date;

public class CheckUpInformation {
    @Id
    private String id;
    private String patientId;
    private String reason;
    private LocalDate dateVisited;
    private LocalDate followUpDate;
    private String hospitalId;
    private String hospitalName;

    public String getId() {
        return id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public @NotNull @NotBlank LocalDate getDateVisited() {
        return dateVisited;
    }

    public void setDateVisited(LocalDate dateVisited) {
        this.dateVisited = dateVisited;
    }

    public @NotNull @NotBlank LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
}