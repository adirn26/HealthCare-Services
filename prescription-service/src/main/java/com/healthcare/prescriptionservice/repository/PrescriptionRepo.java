package com.healthcare.prescriptionservice.repository;

import com.healthcare.basemodels.models.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrescriptionRepo extends MongoRepository<Prescription, String> {

    List<Prescription> findByPatientId(String patientId);

    List<Prescription> findByDoctorId(String doctorId);
}
