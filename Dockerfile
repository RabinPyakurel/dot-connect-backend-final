# Base image with JDK 23
FROM openjdk:23-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set the working directory
WORKDIR /app

# Copy project files
COPY pom.xml ./
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests


# Runtime image
FROM openjdk:23-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar /app/application.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "/app/application.jar"]


#docker build -t your-app-name .
#docker run -p 8080:8080 your-app-name