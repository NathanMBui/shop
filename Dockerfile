FROM openjdk:11
WORKDIR /
ARG JAR_FILE
ADD target/${JAR_FILE} //
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=docker", "/shop-0.0.1-SNAPSHOT.jar" ]