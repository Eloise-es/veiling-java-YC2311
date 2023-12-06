
FROM maven:3.8.7-openjdk-18-slim as build
WORKDIR /usr/src/scaffolded
COPY . .
RUN mvn --batch-mode package
RUN cp target/*jar target/app.jar


FROM openjdk:18-jdk-alpine3.15
USER 1000
ENTRYPOINT ["java","-jar", "./app.jar"]
EXPOSE 8080
COPY --from=build /usr/src/scaffolded/target/app.jar app.jar
