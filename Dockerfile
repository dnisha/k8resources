#STEP 1
FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /app/src
WORKDIR /app
COPY pom.xml .
RUN mvn clean package -DskipTests

#STEP 2
FROM gcr.io/distroless/java17-debian11
COPY --from=maven-builder app/target/springboot-k8sResources-0.0.1-SNAPSHOT.jar /app-service/myapp.jar
WORKDIR /app-service
EXPOSE 8084
ENTRYPOINT ["java","-jar","myapp.jar"]



