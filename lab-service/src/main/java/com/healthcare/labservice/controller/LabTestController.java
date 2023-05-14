package com.healthcare.labservice.controller;

import com.healthcare.basemodels.models.Lab;
import com.healthcare.labservice.service.LabTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lab-tests")
public class LabTestController {

    @Autowired
    private LabTestService labTestService;

    @GetMapping("/")
    public ResponseEntity<List<Lab>> getAllLabTests() {
        List<Lab> labTests = labTestService.getAllLabTests();
        return new ResponseEntity<>(labTests, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Lab> createLabTest(@RequestBody Lab labTest) {
        Lab newLabTest = labTestService.createLabTest(labTest);
        return new ResponseEntity<>(newLabTest, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lab> getLabTestById(@PathVariable String id) {
        Optional<Lab> labTest = labTestService.getLabTestById(id);
        if (labTest.isPresent()) {
            return new ResponseEntity<>(labTest.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<List<Lab>> getLabTestsByPatientId(@PathVariable String patientId) {
        List<Lab> labTests = labTestService.getLabTestsByPatientId(patientId);
        return new ResponseEntity<>(labTests, HttpStatus.OK);
    }

    @GetMapping("/doctors/{doctorId}")
    public ResponseEntity<List<Lab>> getLabTestsByDoctorId(@PathVariable String doctorId) {
        List<Lab> labTests = labTestService.getLabTestsByDoctorId(doctorId);
        return new ResponseEntity<>(labTests, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLabTestById(@PathVariable String id) {
        labTestService.deleteLabTestById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
