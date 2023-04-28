FROM openjdk:17
COPY build/libs/TodoList-0.0.1-SNAPSHOT.jar TodoList.jar
EXPOSE 6080
CMD ["java", "-jar", "TodoList.jar"]