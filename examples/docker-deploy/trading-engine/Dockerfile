FROM openjdk:17
ENV APP_HOME=/apps
WORKDIR $APP_HOME
ADD trading-engine-exec.jar trading-engine-exec.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar"]
CMD ["trading-engine-exec.jar"]