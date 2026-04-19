# Use Java 21 (matches your pom.xml)
FROM eclipse-temurin:21-jdk

# Set working directory inside container
WORKDIR /app

# Copy entire project
COPY . .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the Spring Boot JAR
RUN mvn clean package -DskipTests

# Expose your app port
EXPOSE 8071

# Run the application
CMD ["java", "-jar", "target/user-management-1.0.0.jar"]