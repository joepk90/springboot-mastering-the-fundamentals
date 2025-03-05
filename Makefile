install:
	mvn dependency:resolve

# use maven to run the springboot application
dev:
	./mvnw spring-boot:run