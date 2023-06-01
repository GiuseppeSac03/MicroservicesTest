FROM adoptopenjdk/openjdk11:armv7l-debianslim-jdk-11.0.18_10-slim

# ENV: creazione di una variabile di ambiente
ENV APP_HOME /app

RUN mkdir $APP_HOME
ADD ./target/*.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]