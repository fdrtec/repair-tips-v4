FROM openjdk:20
EXPOSE 8081
ADD target/repair-tips-0.0.1-SNAPSHOT.jar repair-tips-app.jar
ENTRYPOINT [ "java", "-jar", "repair-tips-app.jar" ]

# docker build . -t repair-tips-app:0.0.1
# docker run -p 8081:8081 repair-tips-app:0.0.1


# FROM maven:3.9.6 AS build
# WORKDIR /build
# COPY . .
# RUN mvn clean install

# FROM openjdk:20
# WORKDIR /image
# COPY --from=build ./build/target/*.jar ./artefact.jar
# EXPOSE 8081
# ENTRYPOINT java -jar artefact.jar

# no terminal para criar imagem, predomina a última imagem recriada
# docker build -t fdrtec/repair-tips/api .

# no terminal para rodar container
# docker run -dti -p 8081:8081 --name repair-tips-container --net bridge repair-tips/api