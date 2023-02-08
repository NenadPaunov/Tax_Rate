Tax_Rate Microservice


Tax_Rate is a small microservice built with Spring Boot and Maven as a build tool. The application exposes two REST endpoints and can be run as a Spring Boot application.

Functionality
The application provides two endpoints with an optional path parameter. If the parameter is not provided, a default value of 3 will be used. 
The application fetches its data from a file, as fetching data from a website from a Java application is currently forbidden.

Endpoints
The two endpoints provided by Tax_Rate can be accessed (from localhost) using the following URL pattern:

http://localhost:8080/taxRate/lowestReduced/<optional_path_parameter>
http://localhost:8080/taxRate/highestStandard/<optional_path_parameter>

Documentation
For documentation, Swagger is used and can be accessed at http://localhost:8080/swagger-ui.html#/ when the application is started.

Running the Application
To run the Tax_Rate microservice, simply run it as a Spring Boot application. Once started, the application will be accessible at http://localhost:8080/.
