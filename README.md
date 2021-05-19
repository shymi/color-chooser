# color-chooser
A simple spring application for selecting, saving and visualizing a color

### Build instructions

Current implementation uses Gradle and Spring Boot.

- To build/run the project JDK 11 must be installed
- To run the project from source execute `gradlew bootRun`
- To build the project execute `gradlew clean build` The built jar should be located in `/color-chooser/build/libs`

### Database

For the prototyping purposes(and dev laziness) a h2 database is used for the project

- When starting for the first time `db-data` folder will be created in the project root or the folder,
  from which the jar is executed
- Flyway is used to initialize the tables and fill them with data
- Currently, only RGB colorspace values are populated, but the structure 
is made so other color spaces can be easily added