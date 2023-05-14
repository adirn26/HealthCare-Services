package com.healthcare.labservice.repository;

import com.healthcare.basemodels.models.Lab;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LabTestRepo extends MongoRepository<Lab, String> {

    List<Lab> findByPatientId(String patientId);

    List<Lab> findByDoctorId(String doctorId);
}
