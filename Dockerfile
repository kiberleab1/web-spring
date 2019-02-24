From openjdk:8-jdk-alpine
ENV SPRING_PROFILES_ACTIVE docker
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]

docker run -d \ -p 2012:3306 \ --name mysql-docker-container \ -e MYSQL_ROOT_PASSWORD=root \     -e MYSQL_DATABASE=abeba \     -e MYSQL_USER=ehotel \     -e MYSQL_PASSWORD=test123 \        mysql:latest