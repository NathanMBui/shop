FROM openjdk:11
WORKDIR /
ADD /target/eureka-server-0.0.1.jar //
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "/eureka-server-0.0.1.jar" ]