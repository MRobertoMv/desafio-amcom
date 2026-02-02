FROM maven:3.9.4-eclipse-temurin-21 AS build
ADD . /build
RUN cd /build && mvn package

FROM openjdk:21
COPY --from=build /build/target/*.jar /app.jar
COPY opentelemetry-javaagent.jar /opentelemetry-javaagent.jar
ENTRYPOINT ["java", \
  "-javaagent:/opentelemetry-javaagent.jar", \
  "-Dotel.javaagent.enabled=true", \
  "-Dotel.exporter.otlp.endpoint=<YOUR_HOST>", \
  "-Dotel.exporter.otlp.headers=Authorization=Bearer <YOUR_BEARER_TOKEN>", \
  "-Dotel.logs.explorer=otlp", \
  "-Dotel.metrics.explorer=otlp", \
  "-Dotel.resource.attributes.service.name=<YOUR_SERVICE_NAME>", \
  "-jar", "/app.jar" \
]
