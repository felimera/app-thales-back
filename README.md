# app-thales-back
_____________________________________________
## Table of Contents
* Description
* Settings
  * System pre-configuration
  * Project Configuration
* How to use
  * Get employee
  * Get employee list
* Error Handling
_____________________________________________
## Description
Back-end development project carried out in Spring boot for the consumption of external services provided by the company **Thales**.

* The Java programming language version 17.
* Maven.
* Spring boot version 3.2.3
* Packaging in **war**.
_____________________________________________
## Settings

### System pre-configuration.
* To work on this project, you must have installed:
* The Oracle JDK - Java Development Kit version 17 or OpenJDK version 17 on your computer.
* Add Maven version apache-maven-3.6.3 to your computer.
* Google Chrome browser. This is done to use the WebDriver ChromeDriver.
* Install Wildfly version wildfly-34.0.1.Final.

### Project Configuration
1. Clone the repository https://github.com/felimera/app-thales-back
2. Use IntelliJ IDEA to open the project.
3. After loading all the project's dependencies, you can run it.
4. To generate the WAR file, open a terminal in the root folder. You can use the terminal provided by IntelliJ IDEA and add the command to compile the project:
   * The `mvn clean package` command is a Maven instruction that cleans the project target. It then generates new metadata, compiles the project's source code, runs the unit tests, and packages the project in a specific format, in this case, in a WAR.
   * The `mvn clean package -DskipTests` command is a Maven instruction that does the same thing as the previous point. The difference is that it does not run the project's unit tests, speeding up compilation.
5. When the compilation is complete, go to the target folder and copy or cut the WAR file `app-thales-back-0.0.1-SNAPSHOT.war`.
6. Once you've copied or cut it, you can place it in the Wildfly **deployments** folder `wildfly-34.0.1.Final\standalone\deployments`.
7. Once you've copied it, run Wildfly (this step can be done before or after installing Wildfly). 
   * You can do this by going to the Wildfly bin folder and opening a command prompt.
   * Once you have the command prompt open in the bin, enter the following command: `standalone.bat -c standalone-full.xml` to run Wildfly.
8. When the Wildfly is up you can open a browser and go to the Swagger UI, this is located at http://127.0.0.1:8080/app-thales-back-0.0.1-SNAPSHOT/swagger-ui/index.html , where you can find the two endpoints.
_____________________________________________
## How to use
### Get employee
The get endpoint with the `/api/v1/employee` patch allows you to query a list of employees. To use it, you must do the following:
* Enable the endpoint and press the "**Try it out**" button.
* The "**Execute**" button will then appear. Press it and the query will be generated.
* If the query is successful, you will see a JSON response with the following structure:

```json
[
  {
    "id": 1073741824,
    "name": "string",
    "salary": 0.1,
    "age": 1073741824,
    "image": "string",
    "employeeAnnualSalary": 0.1
  }
]
```

### Get employee list
The get endpoint with the `/api/v1/employee/{id}` patch allows you to query a specific record by ID. To use it, you must do the following:
* Enable the endpoint and press the "**Try it out**" button.
* Enter a valid numeric value in the "**ID**" box.
* Then the "**Execute**" button will appear. Press it and the query will be generated.
* If the query is successful, you will see a JSON response with the following structure:

```json
{
  "id": 1073741824,
  "name": "string",
  "salary": 0.1,
  "age": 1073741824,
  "image": "string",
  "employeeAnnualSalary": 0.1
}
```
_____________________________________________
## Error Handling
If an error occurs during the data query, the endpoint will respond with a code, status, and error description in a JSON structure as shown below:

```json
{
  "code": "ESE-001",
  "status": null,
  "message": "Error Occured! Page Not found, contact rstapi2example@gmail.com"
}
```

* The code is defined at the developer's discretion.
* The status is defined at the developer's discretion, or if the error is coming from an external service, it will correspond to the service error.
* The description is defined at the developer's discretion, or if the error is coming from an external service, it will display the service error response.
_____________________________________________