FROM openjdk:11

COPY . /project
RUN apt-get update \
    && apt-get install -y maven \
    && cd /project \
    && mvn package

#ENTRYPOINT ["java", "-jar", "/project/target/docker-debug-demo-0.0.1-SNAPSHOT.jar"]
CMD ["java", "-jar", "/project/target/docker-debug-demo-0.0.1-SNAPSHOT.jar"]
