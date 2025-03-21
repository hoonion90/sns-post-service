# 빌드 스테이지
FROM openjdk:17-jdk-slim as builder
WORKDIR /app

# Gradle 빌드 파일 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Gradle 실행 권한 부여
RUN chmod +x ./gradlew

# Spring Boot 애플리케이션 빌드
RUN ./gradlew bootJar --no-daemon

# 실행 스테이지
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드한 JAR 파일을 실행 이미지로 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 로그 저장을 위한 디렉터리 생성
RUN mkdir -p /app/logs

# 환경 변수 설정
ENV SPRING_PROFILES_ACTIVE=prod
ENV SERVER_PORT=8081

# 컨테이너에서 노출할 포트 설정
EXPOSE 8081

# 컨테이너가 실행될 때 수행할 명령어 지정
ENTRYPOINT ["java", "-jar", "app.jar"]