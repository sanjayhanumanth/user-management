# 🧑‍💼 User Management API

A production-ready **Spring Boot 3** REST API for managing users — built with Java 21, H2 in-memory database, JPA, and Swagger UI.

---

## 🚀 Tech Stack

| Layer        | Technology                      |
|--------------|---------------------------------|
| Language     | Java 21                         |
| Framework    | Spring Boot 3.3.0               |
| Persistence  | Spring Data JPA + H2 (in-memory)|
| Validation   | Jakarta Bean Validation         |
| API Docs     | SpringDoc OpenAPI (Swagger UI)  |
| Boilerplate  | Lombok                          |
| Build Tool   | Maven                           |

---

## ⚙️ Getting Started

### Prerequisites
- JDK 21+
- Maven 3.8+

### Run the application

```bash
cd user-management
mvn spring-boot:run
```

The server starts on **http://localhost:8071**

---

## 📘 API Documentation

| URL | Description |
|-----|-------------|
| http://localhost:8071/swagger-ui.html | Swagger UI (interactive docs) |
| http://localhost:8071/api-docs        | Raw OpenAPI JSON spec          |
| http://localhost:8071/h2-console      | H2 database console            |

> H2 Console: JDBC URL = `jdbc:h2:mem:userdb`, Username = `sa`, Password = *(empty)*

---

## 📡 API Endpoints

| Method   | Endpoint                          | Description                   |
|----------|-----------------------------------|-------------------------------|
| `GET`    | `/api/v1/users`                   | Get all users                 |
| `GET`    | `/api/v1/users/{id}`              | Get user by ID                |
| `GET`    | `/api/v1/users/username/{name}`   | Get user by username          |
| `GET`    | `/api/v1/users/role/{role}`       | Get users by role             |
| `GET`    | `/api/v1/users/active`            | Get all active users          |
| `GET`    | `/api/v1/users/search?query=John` | Search by first/last name     |
| `POST`   | `/api/v1/users`                   | Create a new user             |
| `PUT`    | `/api/v1/users/{id}`              | Update user                   |
| `PATCH`  | `/api/v1/users/{id}/toggle-status`| Toggle active/inactive        |
| `DELETE` | `/api/v1/users/{id}`              | Delete user                   |

---

## 👥 Roles

| Role      | Description         |
|-----------|---------------------|
| `ADMIN`   | Full access         |
| `MANAGER` | Team-level access   |
| `USER`    | Standard user       |
| `GUEST`   | Read-only access    |

---

## 🌱 Seed Data

On startup, **8 users** are automatically seeded:

| Username       | Role    | Active |
|----------------|---------|--------|
| admin          | ADMIN   | ✅     |
| manager_bob    | MANAGER | ✅     |
| john_doe       | USER    | ✅     |
| jane_smith     | USER    | ✅     |
| charlie_g      | USER    | ❌     |
| diana_p        | MANAGER | ✅     |
| guest_user     | GUEST   | ✅     |
| sam_wilson     | USER    | ✅     |

---

## 🧪 Running Tests

```bash
mvn test
```

---

## 📦 Project Structure

```
src/
├── main/
│   ├── java/com/example/usermanagement/
│   │   ├── config/         # Swagger config
│   │   ├── controller/     # REST controllers
│   │   ├── dto/            # Request & Response DTOs
│   │   ├── exception/      # Custom exceptions & global handler
│   │   ├── model/          # JPA entities & enums
│   │   ├── repository/     # Spring Data repositories
│   │   ├── seed/           # Data seeder (CommandLineRunner)
│   │   └── service/        # Business logic
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/example/usermanagement/
        ├── controller/     # Controller slice tests
        └── service/        # Service unit tests
```
