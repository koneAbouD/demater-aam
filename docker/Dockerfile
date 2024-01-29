#
# Build stage
#
FROM maven:3.9.5-eclipse-temurin-17-alpine AS build
COPY ../src /home/app/src
COPY ../pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install

#
# Package stage
#
FROM openjdk:17-jdk-slim as aam
EXPOSE 9080
COPY --from=build ./home/app/target/demater-aam-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar" ,"/app.jar"]