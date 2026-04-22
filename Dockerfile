FROM maven:3.9-eclipse-temurin-21
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
EXPOSE 8071
CMD ["java", "-jar", "target/user-management-1.0.0.jar"]