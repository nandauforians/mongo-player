# Using Oracle GraalVM for JDK 17
#FROM container-registry.oracle.com/graalvm/native-image:21-ol8 AS builder

# Use a base image that includes Java
FROM openjdk:17-jdk


# Set the working directory inside the container
WORKDIR /app

RUN java -version

# Copy the JAR file from the target directory to the container
COPY target/*.jar player-service.jar

# Expose the port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "player-service.jar"]
