FROM openjdk:11
RUN apt-get update && apt-get install -y maven
COPY . /project
RUN  cd /project && mvn package
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/project/target/client-ledger-service-1.0.0-SNAPSHOT.jar"]
