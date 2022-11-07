FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD ./target/procedure_config-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]