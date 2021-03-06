# vacation-service-project
## Technologies used
- Java 11
- Apache Tomcat - version 9.0.46
- MySQL - version 8.0.24
- Spring framework - version 5.3.9
- Hibernate - version 5.4.27.Final
- JDBC
- Javax Servlet Api - version 4.0.1
- JSTL
- JSP
- HTML, CSS

## Run Project
To run this project need to have installed
- IntelliJ IDEA Ultimate [IDEA](https://www.jetbrains.com/idea/download/#section=windows)
- ApacheTomcat [TOMCAT](https://tomcat.apache.org/download-90.cgi)
- MySQL and MySQL Workbench [MySQL](https://www.mysql.com/downloads/)

- Clone the project on your IDE
- In MySQL Workbench create schema "vacation"
- In src/main/resources/db.properties change USERNAME and PASSWORD with your data
  jdbc.Driver is already provided, but you can change it with more suitable as well

- Configure TomCat Local server (Add New Configuration -> TomCat -> Local -> Fix -> taxi-service:war exploded -> OK)
- Enjoy the project!
