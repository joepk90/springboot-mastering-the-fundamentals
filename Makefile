install:
	mvn dependency:resolve

# use maven to run the springboot application
dev:
	./mvnw spring-boot:run

db-start:
	docker-compose up -d

db-stop:
	docker-compose down

db-delete:
	docker-compose down -v