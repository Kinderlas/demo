package com.kinderlas.demo.springkafka;

import javax.annotation.Resource;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaService {

    public static final String topic = "recommend.captain.sync";

    @Resource
    KafkaTemplate<Object, Object> template;

    public void send(String input) {
        this.template.send("topic_input", input);
    }

    @KafkaListener(topics = {topic}, groupId = "demo_v1", concurrency = "1")
    public void listen(String input) {
        log.info(input);
    }

}
