# ⚽ Futbol Microservices Platform

## 📌 Overview

This repository contains a **microservices-based platform** designed to manage football domain operations, including:

* Users
* Roles
* Countries
* Clubs
* National Teams

Each domain is implemented as an **independent microservice**, following **Hexagonal Architecture (Ports & Adapters)** principles to ensure scalability, maintainability, and clean separation of concerns.

---

## 🏗️ Architecture

The system is built using:

* **Hexagonal Architecture (Ports & Adapters)**
* **Spring Boot**
* **REST APIs**
* **MySQL** (relational persistence)
* **Redis** (caching layer)

### 🔁 Architectural Flow

```
Controller → UseCase → Domain → Port → Adapter → Repository
```

### 🧠 Key Principles

* Domain-driven design approach
* Business logic isolated in the domain layer
* Infrastructure dependencies isolated via adapters
* Easy to extend and test

---

## 📦 Repository Structure

```
Futbol/
│
├── MSRol/              # Role management microservice
├── MSUsuario/         # User management microservice
├── MSPais/            # Country management microservice
├── MSClub/            # Club management microservice
├── MSSeleccion/       # National team management microservice
│
└── README.md          # This file
```

Each microservice:

* Is independently deployable
* Has its own domain, application, and infrastructure layers
* Follows the same architectural standards

---

## 🚀 Microservices

### 🔹 MSRol

Manages role-related operations:

* Create role
* Update role
* Delete role
* Retrieve roles

### 🔹 MSUsuario

Handles user management and identity

### 🔹 MSPais

Manages country data

### 🔹 MSClub

Handles football clubs

### 🔹 MSSeleccion

Manages national teams

---

## ⚙️ Getting Started

### 🔹 Requirements

* Java 17+
* Maven
* MySQL
* Redis

---

### 🔹 Run a microservice

Each microservice can be executed independently:

```bash
cd MSRol
mvn spring-boot:run
```

---

## 🧪 API Documentation

Each microservice exposes REST endpoints.

(You can integrate Swagger/OpenAPI per service if needed)

---

## 🧩 Design Decisions

* Microservices are separated by **business domain**
* Communication between services can be extended via:

  * REST
  * Messaging (future enhancement)
* Redis is used to improve performance and caching

---

## 🔐 Error Handling

* Centralized exception handling per microservice
* Custom domain exceptions
* Standardized API responses

---

## 📈 Future Improvements

* API Gateway
* Service Discovery (Eureka)
* Centralized Config Server
* Docker & Kubernetes deployment
* CI/CD pipelines

---

## 👨‍💻 Author

**Cristhian Torres**
ArakamiTech

---

## 📄 License

Free to use and modify.
