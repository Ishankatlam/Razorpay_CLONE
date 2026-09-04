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



Absolutely. For your GitHub README, you can add a **Today's Progress / Development Log** section like this:

# Today's Development Progress

### Order Management & Order Creation

* Implemented the **Order Creation API** using Spring Boot.
* Created the `OrderRecord` JPA entity with:

  * UUID-based order ID
  * Merchant ID
  * Amount and currency
  * Receipt
  * Order status
  * Attempts
  * Notes (`JSONB`)
  * Expiry time
  * Creation timestamp
* Implemented `OrderStatus` enum:

  * `CREATED`
  * `PENDING`
  * `PAID`
  * `FAILED`
  * `CANCELLED`
  * `EXPIRED`
* Implemented `OrderServiceImpl` with:

  * Duplicate receipt validation
  * Automatic order expiry
  * Default order status as `CREATED`
  * Initial attempts as `0`
  * Order persistence using Spring Data JPA
* Created `CreateOrderRequest` DTO with validation.
* Implemented `Money` as an `@Embeddable` value object.
* Configured PostgreSQL `JSONB` support for order notes.
* Debugged and fixed a PostgreSQL `DataIntegrityViolationException`.
* Identified and removed the obsolete duplicate `orderstatus` database column.
* Corrected the database mapping to use `order_status`.
* Successfully tested the Order Creation API and verified that orders are persisted with `CREATED` status.

### API Testing

Example order creation request:

```json
{
  "amount": {
    "amountUnits": 500,
    "currency": "INR"
  },
  "receipt": "receipt_001",
  "notes": {
    "item": "Laptop"
  },
  "expiresAt": "2026-08-26T22:00:00"
}
```

### Key Learning

> Debugged a real JPA/Hibernate + PostgreSQL schema mismatch and learned how entity field naming, Hibernate naming strategies, and existing database columns can cause persistence errors.
