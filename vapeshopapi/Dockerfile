# =========================
# ETAPA 1: BUILD
# =========================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# Copiamos pom primero para cache
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiamos el código
COPY src ./src

# Compilamos el jar
RUN mvn clean package -DskipTests


# =========================
# ETAPA 2: RUNTIME
# =========================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el jar desde la etapa build
COPY --from=build /app/target/*.jar app.jar

# Puerto que Render expone
EXPOSE 8080

# Variables JVM seguras para Render
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Ejecutar aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
