package com.codefestnepal.dotconnect.repositories;

import com.codefestnepal.dotconnect.models.ActivityLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityLogRepository extends MongoRepository<ActivityLog,String> {

    List<ActivityLog> findAllByPatientIdOrderByDateTimeDesc(String patientId);
}