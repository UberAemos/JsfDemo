FROM openjdk:8
ADD target/jsf-demo.jar jsf-demo.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "user-mysql.jar"]