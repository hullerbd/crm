#FROM openjdk:8-jdk-alpine
#
#
#RUN useradd -d /home/ubuntu -ms /bin/bash -g root -G sudo -p ubuntu ubuntu
#USER ubuntu
#WORKDIR /home/ubuntu
#
#EXPOSE 8080
#VOLUME /tmp
#
#ARG JAR_FILE
#COPY ${JAR_FILE}  app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM anapsix/alpine-java
#mysql
WORKDIR /app
VOLUME /app
COPY mysetup.sh /mysetup.sh

RUN apk add --update mysql mysql-client && rm -f /var/cache/apk/*
COPY mysql.cnf /etc/mysql/my.cnf

EXPOSE 3306
CMD ["/mysetup.sh"]

#add user
RUN apk --update add bash wget dpkg-dev
RUN adduser -D user
USER user

EXPOSE 8080
VOLUME /tmp

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]