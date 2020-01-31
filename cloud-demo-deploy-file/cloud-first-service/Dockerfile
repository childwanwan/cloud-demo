FROM 192.168.126.150:5000/centos:jdk1.8.0

MAINTAINER childwanwan

COPY /cloud-first-service-1.0-SNAPSHOT.jar /tmp/

#RUN bash -c 'touth /tmp/cloud-eureka-2.0-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","/tmp/cloud-first-service-2.0-SNAPSHOT.jar","--spring.config.location=/data/java/config/application.yml"]
