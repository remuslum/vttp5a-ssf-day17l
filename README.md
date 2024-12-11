Multi staging Dcoker using Eclipse

FROM eclipse-temurin:23-jre-noble AS builder

COPY mvnw . 
COPY pom.xml . 

COPY .mvn .mvn
COPY src src

RUN chmod a+x mvnw && mvnw package -Dmaven.test.skip=true

FROM eclipse-temurin:23-jre-noble

WORKDIR /app

COPY --from=builder /src/target/revision.SNAPSHOT.jar app.jar

ENV SERVER_PORT=8080
ENV MY_API_PASS_KEY=xyz789

EXPOSE ${SERVER_PORT}

ENTRYPOINT java -jar app.jar
