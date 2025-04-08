FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew

ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

RUN ./gradlew build

EXPOSE 8080

CMD ["java", "-jar", "build/libs/minha-primeira-api-restful-0.0.1-SNAPSHOT.jar"]