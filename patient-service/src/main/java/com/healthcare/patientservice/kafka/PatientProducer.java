package com.healthcare.patientservice.kafka;

import com.healthcare.basemodels.models.Patient;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PatientProducer {
    private static  final Logger logger = LoggerFactory.getLogger(PatientProducer.class);

    @Autowired
    private NewTopic topic;

    @Autowired
    private KafkaTemplate<String, Patient> kafkaTemplate;

    public void sendMessage(Patient patient){
        logger.info(String.format("Patient registration => %s", patient.toString()));

        Message<Patient> message = MessageBuilder
                .withPayload(patient)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
                .build();

        kafkaTemplate.send(message);
    }
}
