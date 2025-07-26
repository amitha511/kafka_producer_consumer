package com.kafka.demo;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerThread extends Thread {

    private final KafkaProducer<String,String> producer;
    private final String topic ;

    public KafkaProducerThread(String topic) {
        this.topic= topic;
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    public void run(){
        int i=0;
        while(true){
            String messsage = "Hello Kafka" + i ;
            ProducerRecord<String,String> producerRecord=new ProducerRecord<>(topic,i+"hi",messsage);
            producer.send(producerRecord);
            System.out.println("sent to topic :"+ producerRecord.topic() + "\n"+
                    "value: "+ producerRecord.value()+"\n"
            );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
            i++;
        }

        producer.close();
    }
}
