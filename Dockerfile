FROM amazoncorretto:17.0.7-alpine3.17

LABEL maintainer="ashish1tiwar@outlook.com"

WORKDIR /app

COPY target/productService.jar /app/productService.jar

ENTRYPOINT ["java","-Dspring.profiles.active=docker", "-jar", "productService.jar"]