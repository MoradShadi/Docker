# Step 1: Use the Gradle image to build the project
FROM gradle:7.4.2-jdk17 as builder

# Copy the source code into the container
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src

# Build the application without running tests
RUN gradle build --no-daemon -x test

# Step 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Copy the built JAR file from the builder stage
COPY --from=builder /home/gradle/src/build/libs/*.jar app.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
