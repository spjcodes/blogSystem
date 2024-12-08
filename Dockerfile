FROM openjdk:21
LABEL authors="kuro"

RUN mkdir -p /opt/blogBackend/lib
WORKDIR /opt/blogBackend
COPY /target/blog-1.0-SNAPSHOT.jar blog.jar
COPY  /target/lib/* lib/
RUN chmod 777 -R lib

EXPOSE 8080

ENTRYPOINT ["java", "-Dloader.path=/opt/blogBackend/lib", "-jar",  "/opt/blogBackend/blog.jar"]