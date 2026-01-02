# FeedLine – Food Delivery Platform (Backend)

FeedLine is a **production-grade food delivery backend system** built using **Spring Boot**.  
The project is implemented as a **modular monolith**, intentionally designed with **clear service boundaries** to enable a smooth transition to **microservices architecture**.

---

## Tech Stack

- Java 21+
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL / PostgreSQL
- Spring Security (JWT-based authentication)
- Docker & Docker Compose
- Maven

---

## Core Features

- User authentication & authorization (JWT)
- Restaurant onboarding and management
- Menu and item management
- Order lifecycle management
- Payment workflow abstraction
- Delivery assignment model
- Centralized exception handling
- Clean API response contracts

---

## Architecture Philosophy

- Modular Monolith (Domain-driven packaging)
- Clear separation of concerns
- Stateless APIs
- Database-per-service ready design
- Industry-aligned naming conventions

---

## Planned Microservices Split

| Current Module | Future Microservice |
|---------------|--------------------|
| auth          | auth-service       |
| user          | user-service       |
| restaurant    | restaurant-service |
| order         | order-service      |
| payment       | payment-service    |
| delivery      | delivery-service   |

---

## Running Locally

```bash
git clone https://github.com/<your-username>/feedline-platform.git
cd feedline-platform
docker-compose up
