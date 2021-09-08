FROM openjdk:11
WORKDIR /
ADD /target/user-0.0.1.jar //
EXPOSE 8081
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=docker", "/user-0.0.1.jar" ]