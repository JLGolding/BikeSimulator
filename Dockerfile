FROM gradle:jdk11-focal AS build
COPY --chown=gradle:gradle . /BikeSimulator
WORKDIR /BikeSimulator
RUN gradle build --no-daemon 

FROM amazoncorretto:11-al2-full

COPY --from=build /BikeSimulator/app/build/libs/app.jar app.jar

ENTRYPOINT exec java -jar app.jar