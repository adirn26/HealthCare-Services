package com.healthcare.prescriptionservice.controller;

import com.healthcare.basemodels.models.Prescription;
import com.healthcare.prescriptionservice.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/prescriptions")
    public ResponseEntity<?> createPrescription(@RequestBody Prescription prescription){
        Prescription newPrescription = prescriptionService.createPrescription(prescription);
        return new ResponseEntity<>(newPrescription, HttpStatus.OK);
    }

    @GetMapping("/prescriptions/{id}")
    public ResponseEntity<?> getPrescriptionById(@PathVariable("id") String id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id).get();
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @GetMapping("/prescriptions/patient/{patientId}")
    public ResponseEntity<?> getPrescriptionsByPatientId(@PathVariable("patientId") String patientId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByPatientId(patientId);
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @GetMapping("/prescriptions/doctor/{doctorId}")
    public ResponseEntity<?> getPrescriptionsByDoctorId(@PathVariable("doctorId") String doctorId) {
        List<Prescription> prescriptions = prescriptionService.getPrescriptionsByDoctorId(doctorId);
        return new ResponseEntity<>(prescriptions, HttpStatus.OK);
    }

    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<?> updatePrescription(@PathVariable("id") String id, @RequestBody Prescription prescription) {
        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescription);
        return new ResponseEntity<>(updatedPrescription, HttpStatus.OK);
    }

    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity<?> deletePrescription(@PathVariable("id") String id) {
        prescriptionService.deletePrescriptionById(id);
        return new ResponseEntity<>("Prescription deleted successfully", HttpStatus.OK);
    }
}
