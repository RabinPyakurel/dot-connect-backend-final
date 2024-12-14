package com.codefestnepal.dotconnect.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;


public class PatientInformationDto {
    @NotNull
    @NotBlank
    private String patientId;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    @NotNull
    @NotBlank
    private LocalDate dateOfBirth;
    @NotNull
    @NotBlank
    private String gender;
    @NotNull
    @NotBlank
    private String phoneNumber;
    @NotNull
    @NotBlank
    private String citizenshipNumber;
    @NotNull
    @NotBlank
    private String bloodGroup;

    public @NotNull @NotBlank String getFirstName() {
        return firstName;
    }

    public @NotNull @NotBlank String getPatientId() {
        return patientId;
    }

    public void setPatientId(@NotNull @NotBlank String patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(@NotNull @NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @NotBlank String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @NotBlank String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(@NotNull @NotBlank LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull @NotBlank String getGender() {
        return gender;
    }

    public void setGender(@NotNull @NotBlank String gender) {
        this.gender = gender;
    }

    public @NotNull @NotBlank String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull @NotBlank String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @NotNull @NotBlank String getCitizenshipNumber() {
        return citizenshipNumber;
    }

    public void setCitizenshipNumber(@NotNull @NotBlank String citizenshipNumber) {
        this.citizenshipNumber = citizenshipNumber;
    }

    public @NotNull @NotBlank String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(@NotNull @NotBlank String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
