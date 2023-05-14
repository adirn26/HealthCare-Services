package com.healthcare.basemodels.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "prescription")
public class Prescription implements Serializable {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String date;
    private List<Medication> medications;
    private String instructions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Medication implements Serializable {
        private String name;
        private String dosage;
        private String route;
        private String frequency;
        private String duration;
    }
}
