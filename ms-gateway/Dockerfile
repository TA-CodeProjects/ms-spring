FROM openjdk:11-jre-slim-buster
COPY ./target/ms-gateway-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ms-gateway-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ms-gateway-0.0.1-SNAPSHOT.jar"]