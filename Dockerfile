FROM openjdk
MAINTAINER baeldung.com
COPY target/producer-api-*.jar spring-app.jar
ENTRYPOINT ["java","-jar","spring-app.jar"]