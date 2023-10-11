# Test Api 

This project is an example REST api that can be used as a reference, to learn about apis, or to test a frontend POC. 

After downloading code, installing, and running app, simply use the swagger url to test the endpoints. 

## Technologies And Frameworks
- Java 17
- Spring Boot 3
- JUnit 5
- Swagger

## Swagger Link
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## How to use

Start project and open swagger link. Swagger will make it very easy to copy/paste the object shape and fill in as desired.
Use one of the POST endpoints to add your own data, GET to retrieve them, PUT to update, and DELETE to delete. Keep in mind, 
all entities are stored in memory so stopping the project will delete everything as well. 

## Endpoints
``` localhost:8080/api/v1 ```
- Base URL

<br/>

``` GET /data ``` 
- Returns list of all data entities

``` GET /data/{id} ```
- Returns entity with matching id if exists

``` GET /clearList ```
- Deletes all entities in memory

``` POST /data ```
- Add a single entity to list in memory
- Will return 400 if entitiy already exists with same id

``` POST /data/list```
- Add a list of entities to memory

``` PUT /data/{id} ```
- Update an entity
- Will return a 400 error if entity cannot be found with id

``` DELETE /data/{id} ```
- Delete an entity by id




