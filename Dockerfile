# Etapa 1: Build da aplicação
FROM openjdk:21-jdk AS build

# Define diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos necessários para o build
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Copia o restante do código da aplicação
COPY src ./src

# Garante que o mvnw tenha permissão de execução
RUN chmod +x mvnw

# Build do projeto sem rodar testes
RUN mvnw clean package -DskipTests

# Etapa 2: Imagem final para rodar a aplicação
FROM openjdk:21-jdk

WORKDIR /app

# Copia o JAR gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que a aplicação vai rodar (no seu application.properties está como 8081)
EXPOSE 8081

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
