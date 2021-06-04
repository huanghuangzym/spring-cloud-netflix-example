FROM java:8-jdk

ENV DOCKERIZE_VERSION v0.2.0

#ENV http_proxy http://192.168.33.19:8118
#ENV https_proxy http://192.168.33.19:8118

RUN export http_proxy=http://192.168.33.19:8118 && export https_proxy=http://192.168.33.19:8118 && wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app
WORKDIR /app
COPY build/libs/service-b.jar /app
#ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "http://config-server:8100/health", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/service-b.jar", "--spring.profiles.active=docker"]
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/service-b.jar", "--spring.profiles.active=docker"]
EXPOSE 8070
