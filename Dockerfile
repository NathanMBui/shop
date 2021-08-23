FROM openjdk:11
WORKDIR /
ADD target/shop-0.0.1-SNAPSHOT.jar //
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=docker", "/shop-0.0.1-SNAPSHOT.jar" ]