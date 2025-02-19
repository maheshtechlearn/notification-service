# Use a base image with Java installed
FROM eclipse-temurin:17-jre-alpine

# Expose the port your application runs on
EXPOSE 2347


# Copy the JAR file into the container
ADD target/notification-service-0.0.1-SNAPSHOT.jar notification-service-0.0.1-SNAPSHOT.jar


# Command to run the application
ENTRYPOINT ["java", "-jar", "notification-service-0.0.1-SNAPSHOT.jar"]
