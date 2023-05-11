# Set the base image to use for the container
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY target/springboot-k8sResources-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8084

# Start the Spring Boot application when the container starts
CMD ["java", "-jar", "/app/myapp.jar"]

#docker run -e api.url=http://127.0.0.1:49835 -p 8084:8084 dash04/k8resource-java:v4

