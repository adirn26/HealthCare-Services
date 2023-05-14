package com.healthcare.ehrservice.repository;

import com.healthcare.basemodels.models.ElectronicHealthRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EhrRepo extends MongoRepository<ElectronicHealthRecord, String> {

    List<ElectronicHealthRecord> findByPatientId(String patientId);

    List<ElectronicHealthRecord> findByDoctorId(String doctorId);
}
