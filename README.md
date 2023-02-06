# BikeSimulator
Bike Simulator Code Challenge

Writtern using VS Code and Java 11 with the help of Gradle and JUnit 4

when cloning locally use gradle build to build jar file and then run using:

```java -jar app.jar```

app reads inputs both from command line and text file with command seperated by ';'
To red inputs from file add file path to the end of the run command.

eg:
```java -jar app.jar Documents/inputs.text```

Note the code looks for '/' in the file path to determine if it is a file or not

it is also possible to build and ru the porject using docker however only command line inputs are possible
```docker build -t app .```(build)
```docker run -it app``` (run) 


Acceptable commands: FORWARD, TURN_LEFT, TURN_RIGHT GPS_REPORT PLACE X,Y,Direction
All other inputs are ignored (apart from q for ease of stopping the app)

Commands will be ignored until a PLACE X,Y,Direction command is given.

The availble space for the bike to be palced is 7x7 with positions starting from 0 (i.e max 6)
Directions can be NORTH, SOUTH, EAST & WEST

Commands that would move/place the bike out bounds are ignored.

The project has limited the use of 3rd party libraries to testing only where Mockito is used to assist with mocks.
