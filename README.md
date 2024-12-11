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


# Test Redis Connection
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Service;

@Service
public class RedisHealthCheck {

    private final RedisConnectionFactory connectionFactory;

    public RedisHealthCheck(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public boolean isRedisHealthy() {
        try {
            return "PONG".equals(connectionFactory.getConnection().ping());
        } catch (Exception e) {
            // Log the error if needed
            return false;
        }
    }
}

