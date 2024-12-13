package com.codefestnepal.dotconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class MedicationDto {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @NotBlank
    private String hospitalId;
    @NotNull
    @NotBlank
    private String patientId;
    private @NotNull
    @NotBlank LocalDate date;
    @NotNull
    @NotBlank
    private String medicineName;
    @NotNull
    @NotBlank
    private String Frequency;
    private String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public @NotNull @NotBlank String getPatientId() {
        return patientId;
    }

    public @NotNull @NotBlank String getId() {
        return id;
    }

    public void setId(@NotNull @NotBlank String id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(@NotNull @NotBlank String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setPatientId(@NotNull @NotBlank String patientId) {
        this.patientId = patientId;
    }

    public @NotNull @NotBlank LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull @NotBlank LocalDate date) {
        this.date = date;
    }

    public @NotNull @NotBlank String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(@NotNull @NotBlank String medicineName) {
        this.medicineName = medicineName;
    }

    public @NotNull @NotBlank String getFrequency() {
        return Frequency;
    }

    public void setFrequency(@NotNull @NotBlank String frequency) {
        Frequency = frequency;
    }
}

