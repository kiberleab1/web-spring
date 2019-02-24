From openjdk:8-jdk-alpine
ENV SPRING_PROFILES_ACTIVE docker
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]