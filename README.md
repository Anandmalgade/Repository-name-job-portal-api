# Job Portal API

## Overview

Job Portal API is a Spring Boot REST application developed as part of the Java Developer Internship assignment.

The application provides CRUD operations for managing Companies and Jobs using MongoDB.

## Technologies Used

* Java 17
* Spring Boot
* Spring Data MongoDB
* Maven
* MongoDB
* Lombok
* ModelMapper
* Postman

## Features

### Company Management

* Create Company
* Get All Companies
* Get Company By Email
* Update Company
* Delete Company

### Job Management

* Create Job
* Get All Jobs
* Get Job By Id
* Update Job
* Delete Job

### Additional Features

* DTO Pattern
* Validation
* Global Exception Handling
* Custom Exceptions
* MongoDB Integration

## Database Configuration

Configure MongoDB in `application.properties`

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/test
```

## API Endpoints

### Company APIs

| Method | Endpoint               |
| ------ | ---------------------- |
| POST   | /api/companies         |
| GET    | /api/companies         |
| GET    | /api/companies/{email} |
| PUT    | /api/companies/{email} |
| DELETE | /api/companies/{email} |

### Job APIs

| Method | Endpoint       |
| ------ | -------------- |
| POST   | /api/jobs      |
| GET    | /api/jobs      |
| GET    | /api/jobs/{id} |
| PUT    | /api/jobs/{id} |
| DELETE | /api/jobs/{id} |

## Sample Request

### Create Company

```json
{
  "companyName": "TCS",
  "email": "tcs@gmail.com",
  "website": "https://www.tcs.com"
}
```

### Create Job

```json
{
  "jobTitle": "Java Developer",
  "location": "Chennai",
  "salary": 500000,
  "experience": 2,
  "description": "Spring Boot Developer",
  "companyName": "TCS"
}
```

## How to Run

### Clone Repository

```bash
git clone https://github.com/Anandmalgade/Repository-name-job-portal-api.git
```

### Navigate to Project

```bash
cd Repository-name-job-portal-api
```

### Start MongoDB

Ensure MongoDB is running locally on port 27017.

### Run Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8585
```

## Testing

Use Postman to test all APIs.

## Author

Anand Malgade
