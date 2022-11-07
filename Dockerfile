FROM openjdk:17-alpine
ARG PORT=8080
COPY target/sparepartbooking-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]