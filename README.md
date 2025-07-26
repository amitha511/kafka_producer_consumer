# Kafka Producer & Consumer with Docker

## Overview
This project demonstrates a basic setup for Kafka producers and consumers using Docker. It also includes a simple **Kafka UI** for monitoring the Kafka cluster and its messages.

The setup consists of:
- **Zookeeper**: Required for Kafka to manage and coordinate cluster nodes.
- **Kafka**: The distributed streaming platform for producing and consuming messages.
- **Kafka UI**: A simple web UI to visualize topics, partitions, consumers, and messages within Kafka.

## Prerequisites

Before you begin, ensure you have the following installed:

- Docker
- Docker Compose
- Java (for running the Kafka producer and consumer)

## Setup and Running

### Step 1: Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://your-repository-url.git
cd kafka-producer-consumer
```

### Step 2: Docker Compose Setup

The `docker-compose.yml` file defines three services: **Zookeeper**, **Kafka**, and **Kafka UI**. Make sure Docker is running on your system, then start all services with:

```bash
docker-compose up
```
This will start:
* Zookeeper on port 2181
* Kafka on port 9092 (for the host) and 29092 (for internal Docker communication)
* Kafka UI on port 8080

### Step 3: Access Kafka UI
Once the services are up and running, you can access Kafka UI by navigating to:

```bash
http://localhost:8080
```

### Step 4: Running the Producer and Consumer (Java)
Now, let's run the producer and consumer that were implemented in Java:

1. **Compile the Java project**:
    ```bash
    mvn clean install
    ```

2. **Run the Project**

The producer will send messages to Kafka, and the consumer will listen for them. You can observe the output of both the producer and consumer in the terminal.
