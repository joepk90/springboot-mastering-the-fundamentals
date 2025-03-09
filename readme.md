# Springboot - 

## Gobal Dependancies
- Jenv
- Maven

```
$ brew install jenv
$ brew install maven

```

## Maven Central Repository
https://central.sonatype.com/

## Spring Boot Devtools (spring-boot-devtools)
Spring Boot Devtools is used to automatically rebuild and reload the application when changes are made.

When the application is run as a fully packaged application, launched from java -jar file, Spring Boot Devtools is automatically disabled.

For more information see the documentation:
- [docs.spring.io/spring-boot/reference/using/devtools.html](https://docs.spring.io/spring-boot/reference/using/devtools.html#using.devtools)
- [Stack Overflow Thread](https://stackoverflow.com/questions/37701330/spring-boot-dev-tools-turning-them-off-for-production)


## Tutorial Repository:
https://github.com/mosh-hamedani/spring-store


## Database Management
Docker Compose used from the following project:
[github.com/joepk90/docker-sql-server](https://github.com/joepk90/docker-sql-server/)

A few changes have been made to the container, services and volume names. 
Also the 
The image has been updated to arm64v8 version.

To start the database, run the following command:
```
make db-start
```
To manage the data base via the browser using Adminer, go to:
[localhost:8080](http://localhost:8090)

Then enter the following properties to login:
- Server: `springboot_mastering_the_fundamentals_mysql`
- Username: `root`
- Password: `docker_root`

<b>Connect to the mysql server via docker:</b>
```
docker exec -it springboot_mastering_the_fundamentals /bin/bash
```

<b>Login to the mysql server (see root password in `docker-compose.yaml` file):</b>
```
mysql -u root -p
```

