FROM kubespheredev/java-11-centos7 as base 

WORKDIR app

COPY . .
ENTRYPOINT [ "java", "./SimulatorCode/Main.java" ] 

