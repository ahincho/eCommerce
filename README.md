# eCommerce Reactive API

## Descripción

Este proyecto es una API RESTful Reactiva para la gestión de inventarios y órdenes de compra. Permite la administración de productos, categorías, proveedores y órdenes de compra con autenticación basada en JWT y roles de usuario.

## Tecnologías Utilizadas

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring Data R2DBC (PostgreSQL)
- Lombok
- JUnit y Mockito (Pruebas unitarias)
- Swagger/OpenAPI (Documentación de la API)
- Docker y DockerHub

## Instalación y Configuración

### Prerrequisitos

- JDK 21+
- PostgreSQL
- Maven
- Docker (opcional)

### Configuración de la Base de Datos

1. Crear una base de datos en PostgreSQL:
    ```sql
    CREATE DATABASE ecommerce;
    ```
2. Configurar las credenciales en `application.yml`:
    ```yaml
    spring:
      r2dbc:
        url: r2dbc:postgresql://localhost:5432/ecommerce
        username: username
        password: password
    ```

### Ejecución del Proyecto

1. Clonar el repositorio:
    ```sh
    git clone https://github.com/ahincho/eCommerce
    cd eCommerce
    ```
2. Construir y ejecutar la aplicación:
    ```sh
    mvn clean package
    mvn spring-boot:run
    ```

### Uso de la API

La documentación de la API está disponible en:

http://localhost:8080/swagger-ui.html

## Docker y Contenedores

Construir la imagen con el comando

```sh
docker build -t ecommerce:1.0.0 .
```

Ejecución de la aplicación usando Docker

```sh
docker-compose up --build
```

### Pipelines

Integración con Sonar y Sonar Cloud

https://sonarcloud.io/project/overview?id=ahincho-ecommerce

