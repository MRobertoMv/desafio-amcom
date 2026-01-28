# Use a specific JDK image as the base
FROM openjdk:21-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the packaged JAR file into the container
COPY target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
