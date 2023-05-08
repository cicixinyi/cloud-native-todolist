FROM openjdk:17
WORKDIR /app
COPY build/libs/history-0.0.1-SNAPSHOT.jar history.jar
EXPOSE 6080
CMD ["java", "-jar", "history.jar"]