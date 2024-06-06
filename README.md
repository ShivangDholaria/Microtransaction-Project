## Overview
This project is a backend API that records the transactions that are initiated by valid users. 

There are 3 API to work with:
1. Ping
2. Authorize
3. Load

## Details
The APIs does the following:
1. Ping - Checks if the server is alive or not. Returns current TimeStamp is server is up else returns a generic error message
2. Authorize - Debits a the given amount from user and updates their balance. Returns a JSON object with other details and the updated balance of the user. The transaction is recorded for both the cases, approval and denial.
3. Load - Credits a the given amount from user and updates their balance. Returns a JSON object with other details and the updated balance of the user. The transaction is recorded.

The `service.yml` file contains the schemas of the API and other related classes. 

## Bootstrap instructions

System Requirement:
- JDK Version 21
- Apache Maven 3.9.6
- Docker

To run this server locally, you need to have [Java](https://www.java.com/download/ie_manual.jsp) as well as [Maven](https://maven.apache.org/download.cgi?.) installed in your system.


### Installing Java and Maven to System (Windows, Mac, Linux)
- Here's the link to install Java in your system. [Link](https://www.oracle.com/java/technologies/downloads/)
- Here's the link to install maven in your system. 
    - [Link for Windows](https://phoenixnap.com/kb/install-maven-windows)
    - [Link for Mac](https://www.digitalocean.com/community/tutorials/install-maven-mac-os)
    - [Link for Linux](https://www.digitalocean.com/community/tutorials/install-maven-linux-ubuntu)

### Installing Docker to the System (Windows, Mac, Linux)
- Here's the link to install Docker in your system. 
    - [Link for Windows](https://docs.docker.com/desktop/install/windows-install/)
    - [Link for Mac](https://docs.docker.com/desktop/install/mac-install/)
    - [Link for Linux](https://docs.docker.com/desktop/install/linux-install/)

After installing both you should see the following messages.
- For java
    ![java version](/img/java_SS.jpg)
- For maven
    ![maven version](/img/maven_SS.jpg)

After both of them are installed and verified, clone the git repo] to your desired directory.

```bash
git clone https://github.com/ShivangDholaria/Microtransaction-Project.git
```

Open your terminal and navigate to the directory where you cloned the repo. Now go into the repo's directory

```bash
cd Microtransaction-Project
```

Then run the following to run the project locally:
```bash
mvn spring-boot:run
```

You will the following when the project runs perfectly
![Project ran successfully](/img/successful_run.jpg)

Enter the following URL in your browser to see the welcome page.
```http
http://localhost:8080/
```
![](/img/Starter_page.jpeg)
## Design considerations
I decided to use the Spring Boot framework for the following reasons:

1. Simplified Development: Spring Boot provides a streamlined development experience by offering auto-configuration and opinionated defaults. It reduces the boilerplate code required for setting up a Spring application, allowing developers to focus on writing business logic.

2. Dependency Management: Spring Boot manages dependencies through its built-in dependency management system. It automatically resolves and configures the required dependencies, making it easier to manage and update libraries.

3. Community Support: Spring Boot has a large and active community of developers, which means there are plenty of resources, tutorials, and forums available for support. This community-driven ecosystem ensures continuous improvement and updates to the framework.

Initially I decided to go with inline memory as:
1. Performance: Inline memory operations are typically faster than database operations. 

2. Simplicity: Using inline memory eliminates the need for setting up and managing a separate database system. It simplifies the development process by reducing the complexity of database configuration, connection management, and query optimization for a microservice that is going to be used locally.

3. No Database Setup: With inline memory, there is no need to set up and configure a separate database system.This simplifies the development and deployment process, as you don't have to worry about database installation, configuration, or maintenance.

4. Development and Testing: Inline memory is well-suited for development and testing environments where the focus is on rapid iteration and quick feedback. It allows developers to easily manipulate and reset data without the need for complex database setup or data migration scripts.

And now it has been moved to a database.

Using event sourcing pattern in my case was to record every transaction that a user made and appending its record in an event logger. The event logger has only the functionality to append logs to it. Since events are immutable, there is no need for update or remove functionality. For this, I made an event logger class and used to HashMap to store the users and their respective event logs. By using this approach, we are not only able to maintain an immutable transaction history, but also easier to retrieve the state of the user's account in case of data corruption.

I decided to use singleton pattern when the memory was inline on 2 classes, **User** and **EventLogger** class. The reasons being:
- Since inline memory is being used, having a user instance in the RestController class would make it easier and faster to fetch users to perform the trasactions.
- Passing the instances of these classes solved many of the problems that occurred while developing the API.
conflicts or inefficiencies.
- Singleton pattern can improve performance by avoiding the overhead of creating and initializing multiple instances of a class.

To deploy this, I would use Docker for the following advantages:

1. Portability: Docker allows you to package your application and its dependencies into a container, which can be run on any platform that supports Docker. This ensures that your application runs consistently across different environments, making it highly portable.

2. Scalability: Docker makes it easy to scale your application horizontally by running multiple instances of your containerized application. You can easily spin up or down new containers based on the demand, ensuring that your application can handle increased traffic or workload.

3. Isolation: Docker containers provide a high level of isolation, ensuring that your application runs independently of the underlying host system. This isolation helps in preventing conflicts between different applications or dependencies, making your application more stable and secure.

4. Efficiency: Docker containers are lightweight and share the host system's kernel, which means they require fewer resources compared to running multiple virtual machines. This leads to improved resource utilization and better overall performance.

5. Version Control: Docker allows you to version your containers, making it easy to roll back to a previous version if needed. This helps in managing and tracking changes to your application over time.

6. Continuous Integration and Deployment: Docker integrates well with continuous integration and deployment pipelines, allowing you to automate the build, test, and deployment processes. This helps in streamlining your development workflow and ensures faster and more reliable deployments.


Build the image using the command:
```bash
docker image build -t Microtransaction-Project .
```

Run the docker image using the command: 
```bash
docker container run -p 8080:8080 -d Microtransaction-Project
```
