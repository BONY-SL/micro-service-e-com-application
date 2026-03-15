# 🛒 E-Commerce Microservices Architecture

A robust, scalable, and fully event-driven E-Commerce backend built using the **Spring Boot** microservices ecosystem. This project demonstrates handling complex distributed transactions, API routing, configuration management, and asynchronous messaging using industry-standard tools and practices.

## 🚀 Architecture Overview

This application is built using a decentralized microservices architecture. Instead of a monolithic structure, the business domains are separated into independent, containerized services that communicate through API calls and Kafka event streams.

**Key Architecture Components:**
*   **API Gateway:** A single entry point for all client requests, handling routing and cross-cutting concerns.
*   **Service Registry (Eureka):** Dynamic discovery of application instances for load balancing and failover.
*   **Config Server:** Centralized configuration management for all microservices, pulling configurations from an external source.
*   **Decoupled Microservices:** Independent services for Orders, Products, Customers, Payments, and Notifications.
*   **Event-Driven Messaging (Kafka):** Asynchronous communication (e.g., triggering email notifications without blocking the payment or order lifecycle).
*   **Polyglot Persistence:** Dedicated databases for specific service needs (PostgreSQL for relational integrity, MongoDB for flexible document storage).

## 🛠️ Technology Stack

*   **Java 17+**
*   **Spring Boot 3.x**
*   **Spring Cloud** (Gateway, Netflix Eureka, Config)
*   **Apache Kafka** (Event Broker)
*   **PostgreSQL** (Relational Database)
*   **MongoDB** (NoSQL Database)
*   **Docker & Docker Compose** (Containerization)
*   **Postman** (API Testing)

## 📦 Microservices Breakdown

| Service | Port | Description | Database |
| :--- | :--- | :--- | :--- |
| **Config Server** | `8888` | Centralized configuration management. | N/A |
| **Discovery Server** | `8761` | Netflix Eureka server for service registration. | N/A |
| **API Gateway** | `8222` | Spring Cloud Gateway for routing client requests. | N/A |
| **Customer Service** | `8090` | Manages customer profiles and data. | MongoDB |
| **Product Service** | `8050` | Manages inventory, pricing, and product details. | PostgreSQL |
| **Order Service** | `8070` | Handles order creation, validation, and lines. | PostgreSQL |
| **Payment Service** | `8060` | Processes payments and publishes success events. | PostgreSQL |
| **Notification Service** | `8040` | Listens to Kafka topics and sends asynchronous emails. | MongoDB |

## ⚙️ Core Workflows

### 1. Synchronous Communication (OpenFeign & RestTemplate)
When a user places an order, the `Order Service` needs immediate confirmation from other domains:
*   It makes a synchronous call via **OpenFeign** to the `Customer Service` to verify the user exists.
*   It makes a synchronous call via **RestTemplate** to the `Product Service` to verify product availability and deduct inventory.

### 2. Asynchronous Communication (Apache Kafka)
To ensure the system remains highly responsive, non-critical paths are handled asynchronously:
*   Once an order is successfully persisted, the `Order Service` publishes an [OrderConfirmation](cci:2://file:///e:/micro-service-e-com-application/e-commerce-app/services/order/src/main/java/com/diphlk/ecommerce/kafka/OrderConfirmation.java:9:0-17:1) event to the `order-topic`.
*   Once a payment is processed, the `Payment Service` publishes a [PaymentConfirmation](cci:2://file:///e:/micro-service-e-com-application/e-commerce-app/services/notification/src/main/java/com/diphlk/ecommerce/kafka/payment/PaymentConfirmation.java:6:0-17:1) event to the `payment-topic`.
*   The `Notification Service` independently consumes these topics and triggers real-world emails using `JavaMailSender` and Thymeleaf templates.

## 🐳 Running the Application

### Prerequisites
*   Docker & Docker Compose installed
*   Maven installed
*   Java JDK 17+ installed

### Step 1: Start Infrastructure Containers
Start the required databases (Postgres, Mongo) and Kafka/Zookeeper cluster via Docker Compose:

```bash
docker-compose up -d

