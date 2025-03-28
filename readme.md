# Springboot - 

To Start the application, run the following commands:

Start the Database:
```
make db-start
```

Start the Springboot App:
```
make dev
```

To view the Springboot App, go to:
[localhost:8080](http://localhost:8080)


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

### Automatic Databases and Migrations

In `DEV` databases are created automatically due to the `createDatabaseIfNotExist` flag.

Database migrations currently need to be done manually - see the `db-migrate` make command. 

If we want the application to run migrations against the database automatically, the following property can be used:
```
spring.jpa.hibernate.ddl-auto=none # OPTIONS: create, create-drop, validate, update
```



## Model First Migrations (Hybernate)
In the course, an IntelliJ extension called JPA Buddy is used. This extension is used to generate migration files based off of the entities.

As I wasn't using IntelliJ, and didn't want to become dependant on IntelliJ, I setup an alternative solution.

It could be worthwhile setting this up as a seperate module.

See the `db-migration-generate` make command and the `SchemaGenerator` class.

<b>Note:</b>
When generating migration files automatically, a lot of unnessecary migration statements will be created along with the required changes. This is because the database first approach was used at the start of the project, causing the database schema and entities to be out of sync. And when generating the migration sql statements, a lot of defaults are applied which are not represented in the entities defintions.

If we want to resolve this (which could be worth doing at the end of the course), we either need to:
- Apply these unnessecary migration statements
- Update our entities to match the current schema
- Update the original migration statements to use the (Hyerbnate/MySQL8Dialect) defaults 
