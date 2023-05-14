package com.healthcare.basemodels.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "labs")
public class Lab {
    @Id
    private String id;
    private String patientId;
    private String doctorId;
    private String date;
    private String testName;
    private String result;
    private String notes;
}

