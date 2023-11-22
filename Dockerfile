FROM openjdk:17-alpine
COPY ./build/libs/watchapedia-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "app.jar"]