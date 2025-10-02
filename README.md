# Spring Boot Threading Example

A comprehensive Spring Boot application demonstrating various threading and asynchronous programming techniques using
Spring Framework's `@Async` annotation, `TaskExecutor`, and scheduled tasks.

## 🚀 Features

- **Asynchronous Processing** - Demonstrates `@Async` annotation for non-blocking operations
- **Custom Thread Pool Configuration** - Configures multiple `TaskExecutor` beans with custom settings
- **Scheduled Tasks** - Shows periodic task execution using `@Scheduled` annotation
- **JPA Integration** - Employee entity management with H2 in-memory database
- **REST API** - Exposes endpoints to trigger async operations and manage employees
- **CompletableFuture** - Returns asynchronous results using Java's CompletableFuture API

## 📋 Requirements

- **JDK 25** (Amazon Corretto 25+36-LTS)
- **Gradle 8.11.1+**
- **Spring Boot 3.5.6**

## 🛠️ Technology Stack

- **Java 25** - Latest JDK features
- **Spring Boot 3.5.6** - Framework for building production-ready applications
- **Spring Data JPA** - Data access layer
- **H2 Database** - In-memory database for testing
- **Lombok** - Reduces boilerplate code
- **Spring Boot Actuator** - Production-ready monitoring features

## 📦 Project Structure

```
src/main/java/com/hendisantika/springthreading/
├── SpringThreadingApplication.java      # Main application class
├── config/
│   ├── ThreadConfig.java               # Thread pool configuration
│   └── Scheduler.java                  # Scheduled task configuration
├── controller/
│   └── HelloController.java            # REST API endpoints
├── model/
│   └── Employee.java                   # JPA Entity
├── repository/
│   └── EmployeeRepository.java         # Data access layer
└── service/
    ├── AsynchronousService.java        # Async business logic
    └── MyThread.java                   # Custom thread implementation
```

## ⚙️ Configuration

### Thread Pool Configuration

The application configures two `TaskExecutor` beans:

1. **Default Task Executor** (Primary)
    - Core Pool Size: 4
    - Max Pool Size: 4
    - Thread Name Prefix: `default_task_executor_thread`

2. **Specific Task Executor**
    - Uses default settings
    - Named bean: `specificTaskExecutor`

### Database Configuration

The application uses H2 in-memory database with the following settings:

- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`
- **H2 Console**: Enabled at `http://localhost:8080/h2-console`

## 🏃 Running the Application

### Build the project

```bash
./gradlew clean build
```

### Run the application

```bash
./gradlew bootRun
```

Or run the JAR file:

```bash
java -jar build/libs/spring-threading-0.0.1-SNAPSHOT.jar
```

The application will start on `http://localhost:8080`

## 📚 API Endpoints

### 1. Execute Async Task

```bash
GET http://localhost:8080/runTask
```

Triggers an asynchronous task execution.

**Response**: `OK`

### 2. Get All Employees

```bash
GET http://localhost:8080/employees
```

Retrieves all employees asynchronously using `CompletableFuture`.

**Response**:

```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastname": "Doe",
    "email": "john.doe@example.com"
  }
]
```

### 3. Add Employee

```bash
POST http://localhost:8080/employee
Content-Type: application/json

{
  "firstName": "John",
  "lastname": "Doe",
  "email": "john.doe@example.com"
}
```

Creates a new employee record.

## 🔄 Async Processing Examples

### 1. Default Async Method

```java

@Async
@Transactional
public void printEmployees() {
    List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
    employees.stream().forEach(e -> System.out.println(e.getEmail()));
}
```

### 2. Async with Specific Executor

```java

@Async("specificTaskExecutor")
@Transactional
public CompletableFuture<List<Employee>> fetchEmployees() {
    List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
    return CompletableFuture.completedFuture(employees);
}
```

### 3. Scheduled Task

```java

@Scheduled(fixedDelay = 10000)
public void checkTheSchedule() {
    checkAsyncService.printEmployees();
}
```

Executes every 10 seconds.

## 🧪 Testing

Run the test suite:

```bash
./gradlew test
```

## 🔍 H2 Console Access

Access the H2 database console at:

```
http://localhost:8080/h2-console
```

Connection settings:

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

## 📊 Actuator Endpoints

Spring Boot Actuator provides production-ready monitoring features:

```bash
http://localhost:8080/actuator
```

Available endpoints include:

- `/actuator/health` - Application health status
- `/actuator/info` - Application information
- And more...

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 👤 Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## 📝 License

This project is open source and available under the MIT License.

## 🙏 Acknowledgments

- Spring Framework team for excellent async support
- Spring Boot for simplifying application development
- Amazon Corretto for JDK 25 support
