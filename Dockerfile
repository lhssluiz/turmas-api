FROM openjdk:18
COPY ./build/libs/turmas-api-0.0.1-SNAPSHOT.jar turmas-api-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "turmas-api-0.0.1-SNAPSHOT.jar"]