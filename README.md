***# 📚 Student Record Management System - REST API***



***A backend REST API built with Java Spring Boot for managing student academic records.***



***## Features***

***- Full CRUD operations for student records***

***- Filter students by department***

***- Search students by name***

***- Filter by CGPA***

***- Input validation***

***- Global exception handling***



***## Tech Stack***

***| Layer | Technology |***

***|---|---|***

***| Language | Java 20 |***

***| Framework | Spring Boot 3.2 |***

***| ORM | Spring Data JPA + Hibernate |***

***| Database | MySQL |***

***| Build Tool | Maven |***



***## API Endpoints***

***| Method | Endpoint | Description |***

***|---|---|---|***

***| GET | /api/students | Get all students |***

***| GET | /api/students/{id} | Get student by ID |***

***| POST | /api/students | Add new student |***

***| PUT | /api/students/{id} | Update student |***

***| DELETE | /api/students/{id} | Delete student |***

***| GET | /api/students/department/{dept} | Filter by department |***

***| GET | /api/students/cgpa/{cgpa} | Filter by CGPA |***

***| GET | /api/students/search/{name} | Search by name |***



***## How to Run***

***1. Create MySQL database: `CREATE DATABASE studentdb;`***

***2. Update `application.properties` with your MySQL password***

***3. Run: `mvn spring-boot:run`***

***4. API available at: `http://localhost:8080/api/students`***

