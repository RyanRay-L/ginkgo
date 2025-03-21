FROM ubuntu:latest
LABEL authors="雷磊"

ENTRYPOINT ["top", "-b"]


# 使用官方OpenJDK镜像作为基础镜像
FROM openjdk:17-jdk-alpine

# 设置工作目录
WORKDIR /ginkgo

# 将构建的JAR文件复制到容器中
COPY target/ginkgo-0.0.1-SNAPSHOT.jar ginkgo.jar

# 暴露应用端口
EXPOSE 8080

# 启动应用
ENTRYPOINT ["java", "-jar", "app.jar"]