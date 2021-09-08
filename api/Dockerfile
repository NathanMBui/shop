FROM openjdk:11
WORKDIR /
ADD /target/api-0.0.1.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=docker", "/api-0.0.1.jar" ]