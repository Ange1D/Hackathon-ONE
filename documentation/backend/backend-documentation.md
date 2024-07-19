# Documentación Backend

1. [Creación del proyecto](#1-creación-del-proyecto)  

## 1. Creación del proyecto

El proyecto fue creado en [Spring Initializr](https://start.spring.io/) con las siguientes especificaciones:

![Imagen de la creación del proyecto en Spring Initializr](./images/project/01.jpg)

- Gestor de Dependencias: **Gradle - Groovy**
- Versión de Spring Boot: **3.3.1**
- Lenguaje: **Java**
- Empaquetado: **jar**
- Versión de Java: **17**
- Dependencias:

  - **Spring Security**: Utilizada para agregar seguridad a la aplicación. Proporciona las bibliotecas y configuraciones necesarias para implementar autenticación y autorización.
  - **Validation**: Utilizada para realizar validaciones en los datos de entrada de la aplicación.
  - **Flyway Migration**: Utilizada para realizar migraciones de base de datos de manera controlada y automatizada.Es de gran ayuda para administrar y aplicar cambios en la estructura de la base de datos.
  - **MySQL  Driver**: Utilizada para conectarse a una base de datos MySQL desde una aplicación Java. Proporciona las bibliotecas y controladores necesarios para establecer la conexión y ejecutar consultas en la base de datos.
  - **Spring Data JPA**: Utilizada para trabajar con JPA (Java Persistence API) en aplicaciones Spring Boot. Proporciona las bibliotecas y configuraciones necesarias para interactuar con una base de datos utilizando JPA.
  - **Spring Web**: Utilizada para desarrollar aplicaciones web utilizando Spring Boot. Proporciona las bibliotecas y configuraciones necesarias para crear controladores web y manejar solicitudes HTTP.
  - **Lombok**: Utilizada para reducir la cantidad de código en las clases Java. Proporciona anotaciones que generan automáticamente métodos, constructores y otros elementos comunes en las clases.
  - **Spring Boot Dev Tools**: Utilizada para facilitar el desarrollo y la depuración de aplicaciones Spring Boot.

- Adicionalmente se agregaron:

  - **SpringDoc OpenAPI**: Utilizada para documentar y exponer una API REST basada en Spring Boot utilizando OpenAPI y Swagger UI. Proporciona una interfaz de usuario para explorar y probar la API.
  - **JJWT**: Utilizada para trabajar con JWT(JSON Web Tokens). Proporciona las bibliotecas y herramientas necesarias para generar, firmar y verificar tokens JWT.

