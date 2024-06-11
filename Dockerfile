# Start with a base image containing Java runtime
FROM maven:3.9.6-sapmachine-21 AS build

# The application's .jar file
ARG JAR_FILE=target/*.jar

# cd into the project directory
WORKDIR /usr/src/app

# Copy the pom.xml file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline -B

# Copy the project source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Specify the start command
CMD ["java", "-jar", "/usr/src/app/target/transacts-1.0.0.jar"]