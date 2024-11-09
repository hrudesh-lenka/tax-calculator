FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
VOLUME /tmp

COPY --from=build /app/target/taxcalculator.jar /taxcalculator.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/taxcalculator.jar"]
