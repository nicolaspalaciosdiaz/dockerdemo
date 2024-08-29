# Namn från pom.xml, bytten namn från demo till DockerDemo
# Men i pom filen heter som här under.
#	<artifactId>demo</artifactId>
#	<version>0.0.1-SNAPSHOT</version>

FROM openjdk:17

WORKDIR /app

COPY target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT  ["java", "-jar", "app.jar"]