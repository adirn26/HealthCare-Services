package com.healthcare.patientservice.service;

import com.healthcare.basemodels.models.Patient;
import com.healthcare.patientservice.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepo repo;

    public Patient createPatient(Patient patient){
        return repo.save(patient);
    }

    public List<Patient> getAllPatient(){
        return repo.findAll();
    }

    public Patient getPatient(String id){
        Optional<Patient> optionalPatient = repo.findById(id);
        if(optionalPatient.isPresent()){
            return optionalPatient.get();
        }
        else{
            throw new IllegalArgumentException("Patient not found with ID: " + id);
        }
    }

    public Patient updatePatient(String id, Patient patient){
        Optional<Patient> optionalPatient = repo.findById(id);
        if (optionalPatient.isPresent()) {
            Patient existingPatient = optionalPatient.get();
            existingPatient.setFirstName(patient.getFirstName());
            existingPatient.setLastName(patient.getLastName());
            existingPatient.setGender(patient.getGender());
            existingPatient.setDateOfBirth(patient.getDateOfBirth());
            existingPatient.setAddress(patient.getAddress());
            existingPatient.setInsurance(patient.getInsurance());
            return repo.save(existingPatient);
        } else {
            throw new IllegalArgumentException("Patient not found with ID: " + id);
        }
    }

    public void deletePatient(String id){
        Optional<Patient> optionalPatient = repo.findById(id);
        if(optionalPatient.isPresent()){
           repo.delete(optionalPatient.get());
        }
        else {
            throw new IllegalArgumentException("Patient not found with ID: " + id);
        }
    }
}
