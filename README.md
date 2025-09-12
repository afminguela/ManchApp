# ManchApp

**Purpose:**
Make stain removal a simple, quick, and even fun process, offering practical, ecological, and personalized solutions, designed for mothers and young adults on their Adulting 101 journey.

---

## Class Diagram

The project uses JPA inheritance and models such as `Sustancia` (abstract parent), `TipoMancha` (child), `Ingrediente` (child), `Material` (parent), `Tela` (child), and `Superficie` (child). You can find the full class diagram in the file: `Doc/diagramaPost.mmd`.

---

## Setup

1. Clone the repository from GitHub.
2. Configure your MySQL database in `src/main/resources/application.properties`.
3. Build the project using Maven:
   `./mvnw clean install`
4. Run the application:
   `./mvnw spring-boot:run`

---

## Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## Controllers and Routes Structure

- REST API controllers are located in `src/main/java/com/adulting101/ManchApp/controllers/`.
- Example route:
  - `GET /soluciones` (returns cleaning solutions, supports filtering by stain and material)
- Models and DTOs are in `src/main/java/com/adulting101/ManchApp/models/` and `src/main/java/com/adulting101/ManchApp/DTO/`.

---

## Folder Structure

- `src/main/java/com/adulting101/ManchApp/`
  - `controllers/` (REST controllers)
  - `models/` (JPA entities)
  - `repositories/` (Spring Data repositories)
  - `services/` (business logic)
  - `DTO/` (data transfer objects)
  - `enums/` (enumerations)
  - `config/` (configuration classes)
  - `utils/` (utility classes)
- `src/main/resources/`
  - `application.properties` (database and app config)
  - `static/` and `templates/` (if needed for web resources)
- `test/` (unit and integration tests)

---

## Comments and Code Quality

- The code uses clear naming conventions and is organized by feature.
- Comments are present where necessary for clarity.

---

## Documentation

- Class diagrams:
  - `Doc/diagramaPost.mmd`
  - `Doc/Class diagrams.mmd`
- ER diagram:
  - `Doc/ER diagram ManchApp.mmd`
- Project structure PDF:
  - `Doc/Estructura del Proyecto ManchaFácil.pdf`

---

## Deliverables

- A working REST API running locally.
- GitHub repository: [ManchApp GitHub](https://github.com/afminguela/ManchApp.git)
- Class diagram included in the repository.
- Documentation files in the `Doc/` folder.

---

## Team Members

- See contributors in the GitHub repository.

---

## Future Work

- Add more CRUD routes (POST, PUT/PATCH, DELETE).
- Implement robust error handling.
- Add unit and integration tests.
- Optionally, add authentication with Spring Security.

---

## Resources

- All resources and diagrams are included in the `Doc/` folder.
