FROM maven as builder
COPY src /home/app/src
COPY pom.xml /home/app
COPY app.config /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jre-alpine
COPY --from=builder /home/app/target/word-replacement-1.0-SNAPSHOT.jar ./app.jar
EXPOSE 8000
CMD ["java", "-jar", "app.jar"]