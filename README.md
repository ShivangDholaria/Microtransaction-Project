**Important: Don't forget to update the [Candidate README](#candidate-readme) section**

Real-time Transaction Challenge
===============================
## Overview
Welcome to Current's take-home technical assessment for backend engineers! We appreciate you taking the time to complete this, and we're excited to see what you come up with.

You are tasked with building a simple bank ledger system that utilizes the [event sourcing](https://martinfowler.com/eaaDev/EventSourcing.html) pattern to maintain a transaction history. The system should allow users to perform basic banking operations such as depositing funds, withdrawing funds, and checking balances. The ledger should maintain a complete and immutable record of all transactions, enabling auditability and reconstruction of account balances at any point in time.

## Details
The [included service.yml](service.yml) is the OpenAPI 3.0 schema to a service we would like you to create and host.

The service accepts two types of transactions:
1) Loads: Add money to a user (credit)

2) Authorizations: Conditionally remove money from a user (debit)

Every load or authorization PUT should return the updated balance following the transaction. Authorization declines should be saved, even if they do not impact balance calculation.


Implement the event sourcing pattern to record all banking transactions as immutable events. Each event should capture relevant information such as transaction type, amount, timestamp, and account identifier.
Define the structure of events and ensure they can be easily serialized and persisted to a data store of your choice. We do not expect you to use a persistent store (you can you in-memory object), but you can if you want. We should be able to bootstrap your project locally to test.

## Expectations
We are looking for attention in the following areas:
1) Do you accept all requests supported by the schema, in the format described?

2) Do your responses conform to the prescribed schema?

3) Does the authorizations endpoint work as documented in the schema?

4) Do you have unit and integrations test on the functionality?

Here’s a breakdown of the key criteria we’ll be considering when grading your submission:

**Adherence to Design Patterns:** We’ll evaluate whether your implementation follows established design patterns such as following the event sourcing model.

**Correctness**: We’ll assess whether your implementation effectively implements the desired pattern and meets the specified requirements.

**Testing:** We’ll assess the comprehensiveness and effectiveness of your test suite, including unit tests, integration tests, and possibly end-to-end tests. Your tests should cover critical functionalities, edge cases, and potential failure scenarios to ensure the stability of the system.

**Documentation and Clarity:** We’ll assess the clarity of your documentation, including comments within the code, README files, architectural diagrams, and explanations of design decisions. Your documentation should provide sufficient context for reviewers to understand the problem, solution, and implementation details.

# Candidate README
## Bootstrap instructions

System Requirement:
- JDk Version 21
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
git clone https://github.com/codescreen/CodeScreen_1521jlcz.git
```

Open your terminal and navigate to the directory where you cloned the repo. Now go into the repo's directory

```bash
cd CodeScreen_1521jlcz
```

Then run the following to run the project locally:
```bash
mvn spring-boot:run
```

You will the following when the project runs perfectly
![Project ran successfully](/img/successful_run.jpg)

Enter the following URL in your browser to see the welcome page.
![](/img/Starter_page.jpeg)
## Design considerations
*Replace this: I decided to build X for Y reasons.*

I decided to use the Spring Boot framework for the following reasons:

1. Simplified Development: Spring Boot provides a streamlined development experience by offering auto-configuration and opinionated defaults. It reduces the boilerplate code required for setting up a Spring application, allowing developers to focus on writing business logic.

2. Dependency Management: Spring Boot manages dependencies through its built-in dependency management system. It automatically resolves and configures the required dependencies, making it easier to manage and update libraries.

3. Community Support: Spring Boot has a large and active community of developers, which means there are plenty of resources, tutorials, and forums available for support. This community-driven ecosystem ensures continuous improvement and updates to the framework.

I decided to go with inline memory rathan a Database as
1. I decided to go with inline memory rather than a database for the following reasons:

1. Performance: Inline memory operations are typically faster than database operations. 

2. Simplicity: Using inline memory eliminates the need for setting up and managing a separate database system. It simplifies the development process by reducing the complexity of database configuration, connection management, and query optimization for a microservice that is going to be used locally.

3. No Database Setup: With inline memory, there is no need to set up and configure a separate database system.This simplifies the development and deployment process, as you don't have to worry about database installation, configuration, or maintenance.

4. Development and Testing: Inline memory is well-suited for development and testing environments where the focus is on rapid iteration and quick feedback. It allows developers to easily manipulate and reset data without the need for complex database setup or data migration scripts.

A database would be well suited for the scenario where data persistence, durability, and advanced querying capabilities are required. 

### Write about system design
### Write about what used to unit testing
### Explain event sourcing pattern with my example

Using event sourcing pattern in my case was to record every transaction that a user made and appending its record in an event logger. The event logger has only the functionality to append logs to it. Since events are immutable, there is no need for update or remove functionality. For this, I made an event logger class and used to HashMap to store the users and their respective event logs. By using this approach, we are not only able to maintain an immutable transaction history, but also easier to retrieve the state of the user's account in case of data corruption.

### Why used singleton pattern for User and EventLogger class
I decided to use singleton pattern for this assessment on 2 classes, **User** and **EventLogger** class. The reasons being:
- Since inline memory is being used, having a user instance in the RestController class would make it easier and faster to fetch users to perform the trasactions.
- Passing the instances of these classes solved many of the problems that occurred while developing the API.
conflicts or inefficiencies.
- Singleton pattern can improve performance by avoiding the overhead of creating and initializing multiple instances of a class.

## Assumptions
*Replace this: If you made any assumption in designing the service, document it here*

## Bonus: Deployment considerations
To deploy this, I would use Docker for the following advantages:

1. Portability: Docker allows you to package your application and its dependencies into a container, which can be run on any platform that supports Docker. This ensures that your application runs consistently across different environments, making it highly portable.

2. Scalability: Docker makes it easy to scale your application horizontally by running multiple instances of your containerized application. You can easily spin up or down new containers based on the demand, ensuring that your application can handle increased traffic or workload.

3. Isolation: Docker containers provide a high level of isolation, ensuring that your application runs independently of the underlying host system. This isolation helps in preventing conflicts between different applications or dependencies, making your application more stable and secure.

4. Efficiency: Docker containers are lightweight and share the host system's kernel, which means they require fewer resources compared to running multiple virtual machines. This leads to improved resource utilization and better overall performance.

5. Version Control: Docker allows you to version your containers, making it easy to roll back to a previous version if needed. This helps in managing and tracking changes to your application over time.

6. Continuous Integration and Deployment: Docker integrates well with continuous integration and deployment pipelines, allowing you to automate the build, test, and deployment processes. This helps in streamlining your development workflow and ensures faster and more reliable deployments.


Build the image using the command:
```bash
docker image build -t codescreen_1531JLCZ .
```

Run the docker image using the command: 
```bash
docker container run -p 8080:8080 -d codescreen_1531JLCZ 
```

## License

At CodeScreen, we strongly value the integrity and privacy of our assessments. As a result, this repository is under exclusive copyright, which means you **do not** have permission to share your solution to this test publicly (i.e., inside a public GitHub/GitLab repo, on Reddit, etc.). <br>

## Submitting your solution

Please push your changes to the `main branch` of this repository. You can push one or more commits. <br>

Once you are finished with the task, please click the `Submit Solution` link on <a href="https://app.codescreen.com/candidate/e39e065b-2b93-4639-b75d-0ea5c62e5723" target="_blank">this screen</a>.