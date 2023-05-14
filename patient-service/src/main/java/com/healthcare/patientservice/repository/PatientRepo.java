package com.healthcare.patientservice.repository;

import com.healthcare.basemodels.models.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepo extends MongoRepository<Patient, String> {
}
