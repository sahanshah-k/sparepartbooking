FROM openjdk:17-alpine
COPY target/sparepartbooking-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","-Dserver.port=${PORT}","-Dspring.data.mongodb.uri=${MONGO_URI}","/app.jar"]