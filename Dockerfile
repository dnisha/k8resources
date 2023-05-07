FROM gcr.io/distroless/java17-debian11
EXPOSE 8080
WORKDIR /opt/k8sApp
COPY target/*.jar .
CMD ["springboot-k8sResources-0.0.1-SNAPSHOT.jar"]
