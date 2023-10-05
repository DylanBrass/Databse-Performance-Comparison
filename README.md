<br/>
<p align="center">
  <h3 align="center">MySQL vs MongoDB test suite</h3>

</p>



## Table Of Contents

* [About the Project](#about-the-project)
* [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Authors](#authors)
* [Acknowledgements](#acknowledgements)

## About The Project

This project is a suite of tests to observe the performance and behaviour difference with MongoDB and MySQL in a spring boot environment. The goal of the project is not to find out if one is better or is worst, but simply to experiment with different situations that might occurred. I made this project in my 3rd year of my Computer Science DEC at Champlain College.




## Built With

I used Spring boot with docker-compose. I then used the MySQL and MongoDB image this is the docker compose file :
```yml
services:
  test_demo:
    build: .
    hostname: test_demo
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
    depends_on:
      mysql1:
        condition: service_healthy

  mysql1:
    image: mysql:5.7
    ports:
      - "3307:3306"
    environment:
      - MYSQL_ROOT_PASSWORD=rootpwd
      - MYSQL_DATABASE=test-db
      - MYSQL_USER=user
      - MYSQL_PASSWORD=pwd
    volumes:
      - ./data/mysql1:/var/lib/mysql1
      - ./data/init.d:/docker-entrypoint-initdb.d
    healthcheck:
      test:
        [
            "CMD",
            "mysqladmin",
            "ping",
            "-uuser",
            "-ppwd",
            "-h",
            "localhost",
        ]
      interval: 10s
      timeout: 5s
      retries: 10


  phpmyadmin:
    image: phpmyadmin:5.2.0
    container_name: PhpMyAdmin
    links:
      - mysql1
    restart: always
    ports:
      - 5013:80
    environment:
      - PMA_ARBITRARY=1


  mongodb:
    image: mongo
    container_name: mongo_db
    ports:
      - 27017:27017
    volumes:
      - mongo:/data
    environment:
      - MONGO_INITDB_ROOT_USERNAME=user
      - MONGO_INITDB_ROOT_PASSWORD=pwd
  mongo-express:
    image: mongo-express
    container_name: mongo-express
    restart: always
    ports:
      - 8081:8081
    environment:
      - ME_CONFIG_MONGODB_ADMINUSERNAME=user
      - ME_CONFIG_MONGODB_ADMINPASSWORD=pwd
      - ME_CONFIG_MONGODB_SERVER=mongodb
volumes:
  mongo: {}
```

## Getting Started

To get a local copy up and running follow these simple example steps.

### Prerequisites

* docker-compose
https://docs.docker.com/compose/install/

And I highly recommend docker desktop.

* docker desktop
https://www.docker.com/products/docker-desktop/

* postman
https://www.postman.com/



### Installation

1. You clone the project with :
* Https : https://github.com/DylanBrass/MySQLvsMongoDBPerformance.git

2. Get docker up
```sh
docker-compose up --build
```

3. Then use this postman link to make requests :
<a href="https://galactic-comet-561614.postman.co/workspace/Team-Workspace~357ceed0-db35-463d-8eea-3dda3a6c4f22/collection/24252454-714327ae-e874-4aca-a9b5-88926b584834?action=share&creator=24252454">My requests in my postman team</a>

## Usage

I will show a step by step of running the test and seeing the results !

1. First we make the request which can all be found in my postman "team" above:
![image](https://github.com/DylanBrass/MySQLvsMongoDBPerformance/assets/71225455/e91bf1c6-379e-4165-b4be-34a7f4facba8)

2. You click send and wait for the 200 OK

![image](https://github.com/DylanBrass/MySQLvsMongoDBPerformance/assets/71225455/e10124f3-fa13-47b6-a6fb-c9c5ae2fb393)

3. Then you look at the logs, either in the docker-compose one or the container logs in the test_demo container
![image](https://github.com/DylanBrass/MySQLvsMongoDBPerformance/assets/71225455/60cc98fb-12cd-4dba-9ba5-f90ecdfacb33)

![image](https://github.com/DylanBrass/MySQLvsMongoDBPerformance/assets/71225455/8fe09468-f6fb-4f0e-ba86-3d8a5e41d9a5)




## Authors

* **DylanBrass** - *Comp Sci Student* - [DylanBrass](https://github.com/DylanBrass/) - *Built Project*
* **Mila5847** - *Comp Sci Student* - [Mila5847](https://github.com/Mila5847/) - *Added tests*


## Acknowledgements

* [Mila5847](https://github.com/Mila5847)
* [DenisaNicoletaH ](https://github.com/DenisaNicoletaH)
