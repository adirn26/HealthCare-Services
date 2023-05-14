package com.healthcare.ehrservice.controller;

import com.healthcare.basemodels.models.ElectronicHealthRecord;
import com.healthcare.ehrservice.service.EhrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EhrController {

    @Autowired
    EhrService ehrService;

    @PostMapping("/ehr")
    public ResponseEntity<?> createEhr(@RequestBody ElectronicHealthRecord ehr) {
        ElectronicHealthRecord newEhr = ehrService.createEHR(ehr);
        return new ResponseEntity<>(newEhr, HttpStatus.CREATED);
    }

    @GetMapping("/ehr/{id}")
    public ResponseEntity<?> getEhrById(@PathVariable("id") String id) {
        ElectronicHealthRecord ehr = ehrService.getEHRById(id);
        if (ehr == null) {
            return new ResponseEntity<>("EHR not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ehr, HttpStatus.OK);
    }

    @PutMapping("/ehr/{id}")
    public ResponseEntity<?> updateEhr(@PathVariable("id") String id, @RequestBody ElectronicHealthRecord ehr) {
        ElectronicHealthRecord updatedEhr = ehrService.updateEHRById(id, ehr).get();
        if (updatedEhr == null) {
            return new ResponseEntity<>("EHR not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedEhr, HttpStatus.OK);
    }

    @DeleteMapping("/ehr/{id}")
    public ResponseEntity<?> deleteEhr(@PathVariable("id") String id) {
        ehrService.deleteEHRById(id);
        return new ResponseEntity<>("EHR deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/ehr/patient/{patientId}")
    public ResponseEntity<?> getEhrsByPatientId(@PathVariable("patientId") String patientId) {
        List<ElectronicHealthRecord> ehrs = ehrService.findByPatientId(patientId);
        if (ehrs == null || ehrs.isEmpty()) {
            return new ResponseEntity<>("No EHRs found for the patient", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ehrs, HttpStatus.OK);
    }

    @GetMapping("/ehr/doctor/{doctorId}")
    public ResponseEntity<?> getEhrsByDoctorId(@PathVariable("doctorId") String doctorId) {
        List<ElectronicHealthRecord> ehrs = ehrService.findByDoctorId(doctorId);
        if (ehrs == null || ehrs.isEmpty()) {
            return new ResponseEntity<>("No EHRs found for the doctor", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ehrs, HttpStatus.OK);
    }

}
