package com.healthcare.basemodels.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "patient")
public class Patient implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String email;
    private String phone;
    private Address address;
    private Insurance insurance;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Address {

        private String street;
        private String city;
        private String state;
        private String zipCode;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class Insurance {

        private String providerName;
        private String policyNumber;
        private String groupNumber;
        private String planName;
    }
}


