FROM openjdk:23-jdk

ARG APP_DIR=/app

WORKDIR ${APP_DIR}

COPY .mvn .mvn
COPY src src
COPY pom.xml .
COPY mvnw . 
COPY mvnw.cmd .

RUN ./mvnw clean package -Dmaven.tests.skip=true

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

# ENTRYPOINT ./mvnw spring-boot:run
ENTRYPOINT java -jar target/vttp5a-ssf-day17l-0.0.1-SNAPSHOT.jar