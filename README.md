# lost-found

# 👁️‍🗨️ Missing Person Detection Backend (Spring Boot)

This repository contains the backend implementation of the **Missing Person Detection System** built using **Spring Boot**. It provides RESTful APIs to register, search, and manage missing persons and their found data. This backend works in conjunction with a frontend Angular application and a face recognition model for person detection.

---

## 🚀 Features

- 📦 Register missing person details
- 🔍 Search missing persons by:
  - ID Proof
  - System-generated ID
- 📤 RESTful APIs with proper status responses
- 📄 Swagger/OpenAPI support
- 🧠 Integrates with face recognition classifier
- 📋 Centralized response wrapper using `RestResponse`

---

## 🧰 Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Lombok**
- **OpenAPI (Swagger v3)**
- **Maven**
- **MySQL** (or any JPA-supported DB)
- **Slf4j** for logging

---

## 📁 Project Structure

```bash
src
├── controller
│   ├── FoundDataController.java
│   └── MissingPersonController.java
├── service
│   └── MissingPersonService.java
├── model
│   ├── MissingPersonRequestModel.java
│   ├── MissingPersonResponseModel.java
│   └── UserRequestModel.java
├── response
│   └── RestResponse.java

0
🔗 API Endpoints
🧍 MissingPersonController
Method	Endpoint	Description
POST	/missingPerson/missingPersonRegister	Register a new missing person
GET	/missingPerson/findByIdProof?idProof={id}	Search by ID proof
GET	/missingPerson/findById?id={id}	Search by internal ID

🔎 FoundDataController
Method	Endpoint	Description
GET	/foundData/findByIdProof?idProof={id}	Fetch found person data by ID proof

src/main/java/com/lost/found
│
├── controller # REST Controllers (User, MissingPerson, FoundData)
├── convertor # DTO to Entity converters (if any)
├── entity # JPA entities
├── repo # Spring Data JPA Repositories
├── request/model # Request DTOs
├── response/model # Response DTOs
├── restresponse # Generic response wrapper (RestResponse)
├── service # Service layer containing business logic
├── util # Utility classes (if any)
└── MainApplication.java # Spring Boot main class



---

## 📦 Modules and Responsibilities

### 🔹 `MissingPersonController.java`
- **Register missing persons** using their basic info and ID proof.
- **Fetch missing person** by:
  - ID
  - ID Proof

### 🔹 `FoundDataController.java`
- **Detect matched persons** using ID proof.
- Returns a list of potential matches.

### 🔹 `UserController.java`
- Handles user-related operations (signup/login/logout).

---

## 🔧 Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- Swagger/OpenAPI
- Maven
- MySQL

---

## 🧪 API Endpoints (Sample)

### MissingPersonController

```http
POST /missingPerson/missingPersonRegister
GET  /missingPerson/findByIdProof?idProof=123456
GET  /missingPerson/findById?id=101


💬 Contact For queries or feedback, feel free to reach out at: 📧 goutamdogayan143@gmail.com

📧 atulpatel6357@gmail.com

📧 📧 krishnakumarprajapati2003@gmail.com
