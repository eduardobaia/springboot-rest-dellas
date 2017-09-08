# springboot-rest-dellas

A simple Spring-Boot rest application with hibernate and criteria for consults per filter.

To run: 

mvn clean install

mvn spring-boot:run

Endpoints

* http://localhost:9090/user/{id} (GET) get by id
* http://localhost:9090/user (GET) get all
* http://localhost:9090/user?name=teste (GET) find by filter
* http://localhost:9090/user (POST) insert. json= {"name":"name", "startDate":"15/05/2017"}
* http://localhost:9090/user (PUT) update. json= {"id":"1", "name":"name updated", "startDate":"16/05/2017", "version":"0"}
* http://localhost:9090/user/{id} (DELETE) delete by id
 

#### TODO
* update database properties in application.properties (main and test)
* implement internacionalization
