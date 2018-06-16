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
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM anapsix/alpine-java
#FROM openjdk:8-jdk-alpine

#RUN apk --update add mariadb mariadb-client && rm -rf /var/cache/apk/ && \
#sed -ri "s/^(bind-address|skip-networking|log-bin)/# \1/" /etc/mysql/my.cnf && \
#mkdir -p /var/lib/mysql && chown -R mysql:mysql /var/lib/mysql
#COPY run.sh install-db.sh jpetstore-schema.sql jpetstore-dataload.sql /
#RUN chmod a+x /.sh
#RUN /run.sh
#EXPOSE 3306

RUN apk --update add bash wget dpkg-dev
RUN adduser -D user
USER user

EXPOSE 8080
VOLUME /tmp

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]