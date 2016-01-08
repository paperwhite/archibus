# archibus

1. I have uploaded the whole project for the Original File Upload Example, called archibus_1
2. I have uploaded just whole project in the "archibus_uploadtofs" folder for task 1 part1
3. I have uploaded the whole project directory for task1 part 2, it is called Spring4MVCFileDownloadExample.

* How to Set Up?
This project requires installation of Eclipse EE, Maven(m2e extension for eclipse), and Apache Tomcat(v.8).

* For the Original File Upload, please do the following:
- Download archibus_1 and import it as a maven project into Eclipse.
- Right click on the project, and run as -> "Maven Build..." -> specify "package" in Goals
- Once built, make sure there are no console errors, and then run as -> Run as spring boot app
- Open localhost:8080/ on your browser. Explore.

* To run part 1 of task1: Upload File to File System:
- Import the folder archibus_uploadtofs
- The destination folder I have chosen, is: /Users/Paperwhite/Documents/ 
  You can change this folder to the required folder.
- Again build and run it the same way.
- Open localhost:8080/

* To run part 2 of task 1, import project Spring4MVCFileDownloadExample as a web project in Eclipse
- Build it the same way in eclipse
- Then right click on the project, Run As -> Run on server

NOTE: I made separate projects for the two tasks because one is a Spring Boot App(a maven project) and the other is using JSP, a web project using maven.
