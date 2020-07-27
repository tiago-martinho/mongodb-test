# MongoDB API 

This project consists of a simple API that communicates with a MongoDB

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To avoid installs on the local machine and for ease of use I used docker.

I run both mongo and mongo-express instances for easier interaction with the data.
Both have to be in the same network.

Create a network in docker:

```
docker network create mongo-network
```

Run MongoDB:

```
docker run --name mongo --network mongo-network -p 8081:27017 mongo
```

Run mongo-express if you wish:

```
docker run --name mongo-express --network mongo-network -e ME_CONFIG_MONGODB_SERVER=mongo -p 8090:8081 mongo-express
```

This project is a Spring Boot maven project using Java 11. You should have Maven and JDK 11.x.x installed. You can use Oracle's official JDK for personal use [here]( https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).


For the latest version of Maven go [here](https://maven.apache.org/download.cgi)

Get Docker [here](https://www.docker.com/get-started) if you want to use containers

## Build


Build and install dependencies for the api

```
mvn clean install
```

## Run


To run the api:

```
mvn spring-boot:run
```

Requests can be made from the following endpoint:

```
http://localhost:8080/api
```

Or use swagger-ui for ease of use:

```
http://localhost:8080/documentation/swagger-ui/
```


