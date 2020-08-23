FROM openjdk:14-alpine
COPY build/libs/micronautdata684-*-all.jar micronautdata684.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronautdata684.jar"]