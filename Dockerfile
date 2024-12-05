FROM openjdk:23-jdk AS builder

ARG COMPILE_DIR=/code_folder

WORKDIR ${COMPILE_DIR}

COPY .mvn .mvn
COPY src src
COPY pom.xml .
COPY mvnw . 
COPY mvnw.cmd .

RUN ./mvnw clean package -Dmaven.tests.skip=true

# ENV SERVER_PORT=4000

# EXPOSE ${SERVER_PORT}

# docker stop <First 4 digits of container-id>
# ENTRYPOINT ./mvnw spring-boot:run
# ENTRYPOINT java -jar target/vttp5a-ssf-day17l-0.0.1-SNAPSHOT.jar

FROM openjdk:23-jdk

ARG DEPLOY_DIR=/app

WORKDIR ${DEPLOY_DIR}

COPY --from=builder /code_folder/target/vttp5a-ssf-day17l-0.0.1-SNAPSHOT.jar vttp5a-day17l.jar

ENV SERVER_PORT=4000

EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar vttp5a-day17l.jar

