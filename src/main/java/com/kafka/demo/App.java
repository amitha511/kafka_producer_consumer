package com.kafka.demo;


public class App {
    public static void main(String[] args) {
        KafkaProducerThread producerThread1 = new KafkaProducerThread("topic1");
        KafkaConsumerThread consumerThread1 = new KafkaConsumerThread("topic1","consumerGroup1");
        producerThread1.start();
        consumerThread1.start();

        KafkaProducerThread producerThread2 = new KafkaProducerThread("topic2");
        KafkaConsumerThread consumerThread2 = new KafkaConsumerThread("topic2","consumerGroup2");
        producerThread2.start();
        consumerThread2.start();
    }
}
