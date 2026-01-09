# Основываемся на официальном образе OpenJDK
FROM eclipse-temurin:17-jdk-focal

# Копируем артефакт сборки (jar-файл) в контейнер
COPY target/*.jar app.jar

# Назначаем точку входа для запуска приложения
ENTRYPOINT ["java","-jar","/app.jar"]