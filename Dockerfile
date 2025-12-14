# ============================
# 1) BUILD STAGE (Maven + JDK)
# ============================
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn -q dependency:resolve

COPY src ./src

RUN mvn -q clean package -DskipTests


# ============================
# 2) FINAL STAGE (RUNTIME)
# ============================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# 🔐 Crear carpeta para certificados
RUN mkdir /certs

# 🔐 Copiar el keystore al contenedor
COPY keystore.p12 /certs/keystore.p12

# 📦 Copiar el JAR
COPY --from=build /app/target/*.jar app.jar

# 🌐 Exponer puerto HTTPS
EXPOSE 8443

# Variables de entorno (ejemplo)
ENV DB_PORT=3306
ENV SSL_KEYSTORE_PASSWORD=123456

# 🚀 Arrancar Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
