FROM maven:3.8-eclipse-temurin-17

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run