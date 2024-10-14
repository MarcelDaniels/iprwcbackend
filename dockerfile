FROM maven:4.0.0-jdk-21 AS build

WORKDIR /app

COPY pom.xml .

COPY DartWebshop ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jre-slim

WORKDIR /app

COPY --frombuild /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]