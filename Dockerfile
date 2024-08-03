FROM ubuntu:latest as build

RUN apt-get update
RUN apt-get install -y java-22-amazon-corretto-jdk
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:23-slim

EXPOSE 8080

COPY --from=build /target/movie-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java, -jar", "app.jar" ]

