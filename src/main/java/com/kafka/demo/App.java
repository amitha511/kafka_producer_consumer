package com.kafka.demo;


public class App {
    public static void main(String[] args) {
        KafkaProducerThread producerThread1 = new KafkaProducerThread("my-dudu");
        KafkaConsumerThread consumerThread1 = new KafkaConsumerThread("my-dudu","duduGroup");
        producerThread1.start();
        consumerThread1.start();

        KafkaProducerThread producerThread2 = new KafkaProducerThread("bubu");
        KafkaConsumerThread consumerThread2 = new KafkaConsumerThread("bubu","bubuGroup");
        producerThread2.start();
        consumerThread2.start();
    }
}
