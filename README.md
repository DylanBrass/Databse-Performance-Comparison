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
* Http : https://github.com/DylanBrass/MySQLvsMongoDBPerformance.git
* SSH : git@github.com:DylanBrass/MySQLvsMongoDBPerformance.git

2. Get docker up
```sh
docker-compose up --build
```

3. Then use this postman link to make requests :
<a href="https://galactic-comet-561614.postman.co/workspace/Team-Workspace~357ceed0-db35-463d-8eea-3dda3a6c4f22/collection/24252454-714327ae-e874-4aca-a9b5-88926b584834?action=share&creator=24252454">My requests in my postman team</a>

## Usage

Use this space to show useful examples of how a project can be used. Additional screenshots, code examples and demos work well in this space. You may also link to more resources.

_For more examples, please refer to the [Documentation](https://example.com)_

## Authors

* **DylanBrass** - *Comp Sci Student* - [DylanBrass](https://github.com/DylanBrass/) - *Built Project*
* **Mila5847** - *Comp Sci Student* - [Mila5847](https://github.com/Mila5847/) - *Added tests*


## Acknowledgements

* [Mila5847](https://github.com/Mila5847)
* [DenisaNicoletaH ](https://github.com/DenisaNicoletaH)
