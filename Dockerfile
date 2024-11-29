FROM maven:3.9.6 AS builder
WORKDIR /build
COPY . .
RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder ./build/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]

#criar uma rede para os containers
#docker network create repair-tips-network

# no terminal para criar imagem, predomina a última imagem recriada
# docker build . -t fdrtec/repair-tips-api:v4 --no-cache

#ver os problema do container
#docker logs repair-tips-container

# ver imagem fdrtec/repair-tips-api
# docker image ls

# no terminal para rodar container
# docker run -dti -p 8081:8081 --name repair-tips-container --net bridge fdrtec/repair-tips-api