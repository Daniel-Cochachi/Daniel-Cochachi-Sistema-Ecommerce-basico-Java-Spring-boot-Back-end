# Sistema Ecommerce Básico — Backend con Java Spring Boot

API REST básica de un sistema de ecommerce desarrollada con **Java y Spring Boot**.  
El proyecto está enfocado en demostrar fundamentos de **desarrollo backend**, como arquitectura por capas, operaciones CRUD, persistencia con JPA y diseño de APIs REST.


## Descripción

La aplicación permite gestionar los elementos principales de un ecommerce:

- Gestión de **cliente**
- Gestión de **ventas-detalleVenta**
- Gestión de **productos-categoria**
- Operaciones **CRUD** (Crear, Leer, Actualizar, Eliminar)
- Comunicación mediante **API REST**

Sirve como base para seguir agregando funcionalidades y mejoras.


## Tecnologías

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **Base de datos relacional** (MySQL / H2 / PostgreSQL según configuración)
- use MYSQL


## Arquitectura

El proyecto sigue una **arquitectura por capas**, separando responsabilidades:

- **Controller**: recibe y responde las peticiones HTTP
- **Service**: contiene la lógica de negocio
- **Repository**: acceso a la base de datos mediante JPA
- **Model**: entidades del dominio
- **DTO / Mapper**: transferencia y transformación de datos
- **Exception**: manejo de errores


## Estructura del proyecto

src/
├─ main
│ ├─ java/com/example/sistema_ventas_basico
│ │ ├─ controller
│ │ ├─ service
│ │ ├─ repository
│ │ ├─ model
│ │ ├─ dto
│ │ ├─ mapper
│ │ ├─ exception
│ │ └─ SistemaVentasBasicoApplication.java
│ └─ resources
│ └─ application.properties
└─ test
└─ java/com/example/sistema_ventas_basico



## Requisitos

- **Java JDK**
- **Maven**
- Base de datos configurada (por ejemplo MySQL o H2)


## Ejecución

1. Clonar el repositorio:
   
git clone https://github.com/Daniel-Cochachi/Daniel-Cochachi-Sistema-Ecommerce-basico-Java-Spring-boot-Back-end.git


-Configurar la base de datos en application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/ventas_basico_db
spring.datasource.username= tu usuario
spring.datasource.password= tu contraseña

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect


-Ejecutar la aplicación:

mvn clean spring-boot:run

localhost:8080

Pruebas

Los endpoints pueden probarse con herramientas como Postman o Insomnia.
