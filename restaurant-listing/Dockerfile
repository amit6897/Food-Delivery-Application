FROM adoptopenjdk/openjdk17:alpine-jre
WORKDIR /opt
COPY target/*.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app/jar