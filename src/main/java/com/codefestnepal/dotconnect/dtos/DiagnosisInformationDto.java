package com.codefestnepal.dotconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class        DiagnosisInformationDto {
    @NotNull
    @NotBlank
    private String id;
    @NotNull
    @NotBlank
    private String patientId;
    @NotNull
    @NotBlank
    private String hospitalId;
    private @NotNull
    @NotBlank LocalDate date;
    @NotNull
    @NotBlank
    private String diagnosisName;
    @NotNull
    @NotBlank
    private String result;
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

    public @NotNull @NotBlank String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(@NotNull @NotBlank String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public @NotNull @NotBlank LocalDate getDate() {
        return date;
    }

    public void setDate(@NotNull @NotBlank LocalDate date) {
        this.date = date;
    }

    public @NotNull @NotBlank String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(@NotNull @NotBlank String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public @NotNull @NotBlank String getResult() {
        return result;
    }

    public void setResult(@NotNull @NotBlank String result) {
        this.result = result;
    }
}