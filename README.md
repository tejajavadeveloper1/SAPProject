// 9. README.md (Updated Instructions)
# Spring Boot + SAP UI5 Full CRUD Application

## Setup Instructions
1. Clone the repository.
2. Run `./mvnw spring-boot:run` to start the backend server.
3. Access the H2 database console at `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`).
4. Open `http://localhost:8080` in the browser to view the UI.

## API Endpoints
- `GET /api/policies` - Retrieve all policies
- `GET /api/policies/{id}` - Retrieve policy by ID
- `POST /api/policies` - Add a new policy
- `PUT /api/policies/{id}` - Update a policy
- `DELETE /api/policies/{id}` - Delete a policy

## Tech Stack
- Java + Spring Boot
- SAP UI5 (Frontend)
- H2 In-memory Database
- Maven (Build Tool)
