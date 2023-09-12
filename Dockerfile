FROM openjdk:8-jdk-alpine

EXPOSE 8080

ADD target/springBootRest-0.0.1-SNAPSHOT.jar task2.jar

CMD ["java", "-jar", "task2.jar"]
