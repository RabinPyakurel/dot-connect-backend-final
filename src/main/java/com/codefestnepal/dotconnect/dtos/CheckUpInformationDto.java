package com.codefestnepal.dotconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;


public class CheckUpInformationDto {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @NotBlank
    private String patientId;
    @NotNull
    @NotBlank
    private String reason;
    @NotNull
    @NotBlank
    private LocalDate dateVisited;
    @NotNull
    @NotBlank
    private LocalDate followUpDate;
    @NotNull
    @NotBlank
    private String hospitalId;

private String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public @NotNull @NotBlank String getId() {
        return id;
    }

    public void setId(@NotNull @NotBlank String id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull @NotBlank String patientId) {
        this.patientId = patientId;
    }

    public @NotNull @NotBlank String getReason() {
        return reason;
    }

    public void setReason(@NotNull @NotBlank String reason) {
        this.reason = reason;
    }

    public LocalDate getDateVisited() {
        return dateVisited;
    }

    public void setDateVisited(@NotNull @NotBlank LocalDate dateVisited) {
        this.dateVisited = dateVisited;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(@NotNull @NotBlank LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    public @NotNull @NotBlank String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(@NotNull @NotBlank String hospitalId) {
        this.hospitalId = hospitalId;
    }
}
