package com.healthcare.smsservice.kafka;

import com.healthcare.basemodels.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class PatientConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PatientConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Patient patient){
        logger.info(String.format("Patient object recieved in email service => %s", patient.toString()));
        //save the email to the customer
    }


}
