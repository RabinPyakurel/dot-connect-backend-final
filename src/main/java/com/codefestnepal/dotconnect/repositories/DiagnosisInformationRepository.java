package com.codefestnepal.dotconnect.repositories;


import com.codefestnepal.dotconnect.models.CheckUpInformation;
import com.codefestnepal.dotconnect.models.DiagnosisInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DiagnosisInformationRepository extends MongoRepository<DiagnosisInformation,String> {
public List<DiagnosisInformation> findAllByPatientIdOrderByDateDesc(String patientId);

}