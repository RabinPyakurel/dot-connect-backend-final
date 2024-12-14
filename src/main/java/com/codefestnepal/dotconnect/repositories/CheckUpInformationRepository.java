package com.codefestnepal.dotconnect.repositories;

import com.codefestnepal.dotconnect.models.Agency;
import com.codefestnepal.dotconnect.models.CheckUpInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckUpInformationRepository extends MongoRepository<CheckUpInformation,String> {
public List<CheckUpInformation> findAllByPatientIdOrderByDateVisitedDesc(String patientId);
}
