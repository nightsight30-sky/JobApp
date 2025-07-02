FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar jobapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jobapp.jar"]
