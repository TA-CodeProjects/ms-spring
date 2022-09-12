FROM openjdk:11-jre-slim-buster
COPY ./target/ms-config-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch ms-config-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","ms-config-0.0.1-SNAPSHOT.jar"]