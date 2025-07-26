package com.kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerThread extends Thread{
    private final KafkaConsumer<String,String> consumer;
    private final String topic;


    public KafkaConsumerThread(String topic,String group) {
        this.topic=topic;
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", group);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest");

        this.consumer= new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
    }

    public void run(){
        while(true){
            ConsumerRecords<String, String> consumerRecords= consumer.poll(Duration.ofMillis(1000));
            for(ConsumerRecord<String, String> record : consumerRecords){
                System.out.println("Received from topic: "+ record.topic()+"\n"+
                        "record partition: "+ record.partition()+"\n"+
                        "record key: "+ record.key()+"\n"+
                        "record offset: "+ record.offset()+"\n"+
                        "record value: "+ record.value()+"\n"
                        );
            }

        }

    }
}
