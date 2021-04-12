FROM java:14
COPY *.jar /app.jar
CMD ["--server.port=7001"]
EXPOSE 8080
VOLUME /tmp
ADD erueka-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

