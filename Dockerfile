# Estágio de Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
# Copia apenas o pom.xml primeiro para aproveitar o cache das dependências
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# O nome do jar geralmente segue o padrão artefato-versão.jar
COPY --from=build /app/target/*.jar turismo-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "turismo-api.jar"]