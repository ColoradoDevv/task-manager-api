# Task Manager API

A robust, secure REST API for Task Management built with Java 17 and Spring Boot 3. Features JWT authentication, role-based access control, and comprehensive API documentation.

## 🚀 Features

- **User Authentication**: Secure registration and login using JSON Web Tokens (JWT).
- **Task Management**: Full CRUD operations (Create, Read, Update, Delete) for tasks.
- **Security**:
  - Stateless session management.
  - Password encryption using BCrypt.
  - Role-based authorization (User/Admin).
- **Documentation**: Interactive API documentation via Swagger UI / OpenAPI.
- **Database**: MySQL persistence with H2 fallback for development.

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Security**
- **Spring Data JPA**
- **MySQL Driver**
- **Lombok**
- **OpenAPI / Swagger**

## ⚙️ Getting Started

### Prerequisites

- Java 17 SDK
- Maven (wrapper included)
- MySQL Server (optional, for production-like env)

### Installation

1.  **Clone the repository**
    ```bash
    git clone https://github.com/ColoradoDevv/task-manager-api.git
    cd task-manager-api
    ```

2.  **Configuration**
    - The default configuration expects a MySQL server running on `localhost:3306` with a database named `task_manager_db`.
    - You can update `src/main/resources/application.properties` with your credentials.

### Running the Application

#### Option 1: With MySQL (Recommended)
Ensure your MySQL server is running, then execute:
```bash
./mvnw spring-boot:run
```

#### Option 2: With H2 Database (Dev Mode)
If you don't have MySQL installed or want a quick start, use the `dev` profile to run with an in-memory database:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 📖 API Documentation

Once the application is running, access the interactive Swagger UI at:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 📂 Project Structure

```
src/main/java/com/coloradodev/task_manager_api
├── config/          # Security and Swagger configuration
├── controller/      # REST Controllers
├── dto/             # Data Transfer Objects
├── entity/          # JPA Entities
├── exception/       # Global Exception Handling
├── repository/      # Data Access Layer
├── security/        # JWT Authentication Logic
└── service/         # Business Logic
```

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.