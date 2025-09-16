# ManchApp 🧼✨

## 🎯 Descripción del Proyecto

**ManchApp** es una API REST desarrollada con Spring Boot, diseñada para hacer que la eliminación de manchas sea un proceso simple, rápido e incluso divertido. Nuestro objetivo es ofrecer soluciones de limpieza prácticas, ecológicas y personalizadas, pensadas especialmente para madres y jóvenes adultos en su viaje de "Adulting 101".

Con ManchApp, puedes obtener recomendaciones de limpieza filtrando por el tipo de mancha y el material afectado, haciendo que el cuidado de la ropa y las superficies del hogar sea más fácil que nunca.

---

## 🎨 Diagrama de Clases

El diseño del proyecto se basa en herencia JPA para modelar las diferentes entidades de nuestro dominio. Las clases principales incluyen:

- **`Sustancia`**: Clase padre abstracta.
- **`TipoMancha`**: Entidad hija que representa tipos específicos de manchas.
- **`Ingrediente`**: Entidad hija que representa los ingredientes para las soluciones.
- **`Material`**: Clase padre para los materiales que se pueden manchar.
- **`Tela`**: Entidad hija para tipos de tela.
- **`Superficie`**: Entidad hija para tipos de superficie.

Puedes encontrar los diagramas de clases y el diagrama Entidad-Relación en la carpeta `Doc/` del repositorio:
- **Diagrama de Clases:** `Doc/Class diagrams.mmd`
- **Diagrama ER:** `Doc/ER diagram ManchApp.mmd`

---

## 🚀 Instalación y Puesta en Marcha (Setup)

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local:

1.  **Clona el repositorio desde GitHub:**
    ```bash
    git clone https://github.com/afminguela/ManchApp.git
    cd ManchApp
    ```

2.  **Configura tu base de datos MySQL:**
    -   Abre el archivo `src/main/resources/application.properties`.
    -   Modifica las propiedades `spring.datasource.url`, `spring.datasource.username` y `spring.datasource.password` con los datos de tu base de datos local.

3.  **Construye el proyecto con Maven:**
    ```bash
    ./mvnw clean install
    ```

4.  **Ejecuta la aplicación:**
    ```bash
    ./mvnw spring-boot:run
    ```
La API estará disponible en `http://localhost:8080`.

---

## 🛠️ Tecnologías Utilizadas

-   **Backend:** Java 17+, Spring Boot
-   **Base de Datos:** Spring Data JPA, MySQL
-   **Gestión de Dependencias:** Maven
-   **Documentación API:** Swagger
-   **Apoyo en Debugging y documentacion** Claude Sonnet4, Gamma, Perplexity
-   **IDE y otros SW** IntelliJ, Postman
---

## 📁 Estructura de Rutas y Controladores

La API REST está organizada siguiendo las mejores prácticas de Spring Boot.

-   **Controladores:** Se encuentran en `src/main/java/com/adulting101/ManchApp/controllers/`.
-   **Ruta de ejemplo:**
    -   `GET /soluciones`: Devuelve una lista de soluciones de limpieza. Soporta filtrado por tipo de mancha y material a través de parámetros de consulta (por ejemplo, `GET /soluciones?tipoMancha=vino&material=algodon`).
-   **Documentación de la API con Swagger:**
    -   Una vez que la aplicación está en ejecución, puedes acceder a la interfaz de Swagger UI para ver y probar todos los endpoints disponibles:
    -   **URL de Swagger:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🔗 Enlaces Extra


-   **Presentación del Proyecto:** `https://gamma.app/docs/8de5wyitk81uyu3?following_id=3o66zdtykakuznq&follow_on_start=true` (Gamma)
-   **Acceso a Swagger UI:**  `http://localhost:8080/swagger-ui.html` (despues de complilar la api).

---

## 🔮 Trabajo Futuro (Future Work)

-   [ ] **Crear un sistema de Usuarios** que tenga diversos roles: user, admin...
-   [ ] **Implementar rutas CRUD completas** (POST, PUT/PATCH, DELETE) para todas las entidades para que desde admin se pueda modificar la BBDD.
-   [ ] **Diferentes nivels de filtro** para poder seleccionar antes de la consultas que nos devuelva solo soluciones ECO.
-   [ ] **Implementar autenticación y seguridad** utilizando Spring Security y JWT.

---

## 📚 Recursos

Toda la documentación adicional, diagramas y recursos del proyecto se encuentran en la carpeta `/Doc`.

- GitHub repository: [ManchApp GitHub](https://github.com/afminguela/ManchApp.git)



