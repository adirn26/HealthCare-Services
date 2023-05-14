package com.healthcare.labservice.service;

import com.healthcare.basemodels.models.Lab;
import com.healthcare.labservice.repository.LabTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabTestService {

    @Autowired
    LabTestRepo labTestRepository;

    public List<Lab> getAllLabTests() {
        return labTestRepository.findAll();
    }

    public Lab createLabTest(Lab labTest) {
        return labTestRepository.save(labTest);
    }

    public Optional<Lab> getLabTestById(String id) {
        return labTestRepository.findById(id);
    }

    public List<Lab> getLabTestsByPatientId(String patientId) {
        return labTestRepository.findByPatientId(patientId);
    }

    public List<Lab> getLabTestsByDoctorId(String doctorId) {
        return labTestRepository.findByDoctorId(doctorId);
    }

    public void deleteLabTestById(String id) {
        labTestRepository.deleteById(id);
    }

}
