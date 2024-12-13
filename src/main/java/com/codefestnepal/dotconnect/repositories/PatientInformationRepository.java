package com.codefestnepal.dotconnect.repositories;

import com.codefestnepal.dotconnect.models.PatientInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PatientInformationRepository extends MongoRepository<PatientInformation, String> {
    Optional<PatientInformation> findByCitizenshipNumberIgnoreCase(String citizenshipNumber);
}

