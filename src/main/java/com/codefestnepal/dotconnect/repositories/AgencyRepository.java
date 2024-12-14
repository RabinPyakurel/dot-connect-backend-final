package com.codefestnepal.dotconnect.repositories;

import com.codefestnepal.dotconnect.models.Agency;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AgencyRepository extends MongoRepository<Agency,String> {
    Optional<Agency> findByUsernameIgnoreCase(String username);
}