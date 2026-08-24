# Razorpay Backend

A Spring Boot based payment gateway backend project inspired by Razorpay.
The project is being developed as a backend system with merchant
management, authentication, API key management, exception handling,
and payment-related functionality.

---

## 📌 Project Overview

This project aims to build a scalable payment gateway backend using
Java and Spring Boot.

The backend provides REST APIs for merchant registration,
authentication, API key generation, and other payment gateway
operations.

---

## 🚀 Features

### Merchant Management

- Merchant registration
- Merchant information management
- Business type handling
- Merchant validation

### Authentication

- Merchant signup
- Application user management
- Authentication service
- Validation of existing users

### API Key Management

- Generate API keys for merchants
- Associate API keys with merchants
- Store API key information
- API key related REST endpoints

### Exception Handling

The application uses global exception handling to provide
consistent error responses.

Implemented exceptions include:

- `ResourceNotFoundException`
- `DuplicateResourceException`
- Global exception handling using `@RestControllerAdvice`
- Centralized error response structure

### Duplicate Resource Handling

If a merchant tries to register using an email or username that
already exists, the application returns an appropriate error response.

Example:

- HTTP Status: `409 CONFLICT`
- Exception: `DuplicateResourceException`

![Duplicate Merchant Error](images/messageForErrorOfDuplicate.png)

---

## 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java | Backend programming |
| Spring Boot | Backend framework |
| Spring Data JPA | Database interaction |
| Hibernate | ORM |
| PostgreSQL | Database |
| Maven | Dependency management |
| REST API | API communication |
| Postman | API testing |
| Git & GitHub | Version control |

---

## 📂 Project Structure

```text
razorpay/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── ishanknjr/
│       │           └── razorpay/
│       │
│       │               ├── common/
│       │               │   ├── enums/
│       │               │   └── exceptions/
│       │               │
│       │               ├── merchant/
│       │               │   ├── controller/
│       │               │   ├── DTO/
│       │               │   ├── entity/
│       │               │   ├── Repository/
│       │               │   └── Service/
│       │               │
│       │               └── operations/
│       │
│       └── resources/
│           └── application.yaml
│
├── images/
│   └── messageForErrorOfDuplicate.png
│
├── pom.xml
└── README.md

DuplicateResourceException
ResourceNotFoundException
ErrorResponse
GlobalExceptionHandler

#Example Response
{
  "status": 409,
  "message": "Merchant already exists"
}