# Используем базовый образ OpenJDK 17
FROM openjdk:17

# Устанавливаем переменные среды для подключения к базе данных
ENV DATABASE_URL=jdbc:postgresql://localhost:5432/postgres
ENV DATABASE_USERNAME=postgres
ENV DATABASE_PASSWORD=Hbgtbh1234

# Создаем рабочий каталог внутри контейнера
WORKDIR /usr/src/myapp

# Копируем JAR-файл вашего приложения в контейнер
COPY . /usr/src/myapp

RUN javac src/main/java/com/users/users/UsersApplication.java

# Определяем команду для запуска Spring-приложения
CMD ["java", "UsersApplication"]

CMD ["java", "UsersApplication"]