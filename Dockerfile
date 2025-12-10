# ============================
# 1) BUILD STAGE (Maven + JDK)
# ============================
FROM maven:3.9-eclipse-temurin-17 AS build

# Crear carpeta de trabajo
WORKDIR /app

# Copiar pom.xml y descargar dependencias (cache)
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Construir el JAR
RUN mvn -q clean package -DskipTests


# ============================
# 2) FINAL STAGE
# ============================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Variables de entorno
ENV DB_PORT=3306

ENTRYPOINT ["java", "-jar", "app.jar"]
