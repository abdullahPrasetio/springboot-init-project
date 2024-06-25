# Stage 1: Build the application
FROM maven:3.9.7-eclipse-temurin-22-alpine AS builder
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
# RUN mvn dependency:go-offline

# Copy the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests -Pprod
# RUN mvn clean install

# Stage 2: Run the application
FROM openjdk:22-jdk-slim

WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/*.jar /app/demo_api.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/demo_api.jar"]
