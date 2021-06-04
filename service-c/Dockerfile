FROM java:8-jdk

ENV DOCKERIZE_VERSION v0.2.0


RUN mkdir /app
WORKDIR /app
COPY build/libs/service-c.jar /app
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/service-c.jar", "--spring.profiles.active=docker"]
EXPOSE 8070
