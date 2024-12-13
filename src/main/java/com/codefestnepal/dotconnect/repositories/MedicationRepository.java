package com.codefestnepal.dotconnect.repositories;

import com.codefestnepal.dotconnect.models.CheckUpInformation;
import com.codefestnepal.dotconnect.models.Medication;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicationRepository extends MongoRepository<Medication,String> {
public List<Medication> findAllByPatientIdOrderByDateDesc( String patientId);
}
