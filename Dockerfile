# -------- Stage 1: Build --------
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy only pom first (better caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build jar
RUN mvn clean package -DskipTests


# -------- Stage 2: Run --------
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copy only the built jar from build stage
COPY --from=build /app/target/user-management-1.0.0.jar app.jar

EXPOSE 8071

CMD ["java", "-jar", "app.jar"]