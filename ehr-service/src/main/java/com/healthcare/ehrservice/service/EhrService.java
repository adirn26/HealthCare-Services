package com.healthcare.ehrservice.service;

import com.healthcare.basemodels.models.ElectronicHealthRecord;
import com.healthcare.ehrservice.repository.EhrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EhrService {

    @Autowired
    EhrRepo ehrRepository;

    public List<ElectronicHealthRecord> getAllEHRs() {
        return ehrRepository.findAll();
    }

    public ElectronicHealthRecord getEHRById(String id) {
        return ehrRepository.findById(id).get();
    }

    public ElectronicHealthRecord createEHR(ElectronicHealthRecord ehr) {
        return ehrRepository.save(ehr);
    }

    public Optional<ElectronicHealthRecord> updateEHRById(String id, ElectronicHealthRecord ehr) {
        Optional<ElectronicHealthRecord> existingEHR = ehrRepository.findById(id);
        if (existingEHR.isPresent()) {
            ehr.setId(id);
            return Optional.of(ehrRepository.save(ehr));
        } else {
            return Optional.empty();
        }

    }

    public List<ElectronicHealthRecord> findByPatientId(String patientId) {
        return ehrRepository.findByPatientId(patientId);
    }

    public List<ElectronicHealthRecord> findByDoctorId(String doctorId) {
        return ehrRepository.findByDoctorId(doctorId);
    }


    public void deleteEHRById(String id) {
        ehrRepository.deleteById(id);
    }
}
