FROM openjdk:11-jre-slim-buster
COPY ./target/ms-service-a-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ms-service-a-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ms-service-a-0.0.1-SNAPSHOT.jar"]