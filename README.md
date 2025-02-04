# Marker API

Marker API is a Spring Boot based project that allows the management of markers on a map through a REST API. This project includes operations to create, read, update and delete markers.

## Prerequisites

Make sure you have the following components installed before cloning and running the project:

- Java 17 or higher
- Maven 3.6.3 or higher
- MySQL 8.0 or higher

## Clone the repository

To clone the repository, run the following command in your terminal:

```sh
git clone https://github.com/AlejFernandezV/map-app-back.git
cd map-app-back
```

## Database configuration

Before running the application, make sure you to setup MySQL database correctly. Firstable, create a database called 'markers' and set the connection credential in the application.properties file located in 'src/main/resources/'

```
spring.datasource.url=jdbc:mysql://localhost:3306/markers
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Build and run application

To build and run the application, follow this steps:

 1. Navigate to the project directory
 2. Execute the follow command to build the project with Maven:
 ```sh
    mvn clean install
 ```
 3. Once the build is successful, run the application with the following command:
 ```sh
    mvn spring-boot:run
 ```
After this, the application will be available in 'http://localhost:8080'

## API Endpoints
- GET /api/markers/: Get all the markers.
- GET /api/markers/{id}: Get a marker by Id.
- POST /api/markers/: Create a new marker.
- PUT /api/markers/{id}: Update a marker by Id.
- DELETE /api/markers/{id}: Delete a marker by Id.