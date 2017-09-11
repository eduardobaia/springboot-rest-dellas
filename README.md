# springboot-rest-dellas

A simple Spring-Boot rest application with hibernate and criteria for consults per filter.

To run: 

mvn clean install

mvn spring-boot:run

Endpoints

* http://localhost:9090/user/{id} (GET) get by id
* http://localhost:9090/user (GET) get all
* http://localhost:9090/user/?name=name&profile=E (GET) find by filter
* http://localhost:9090/user (POST) insert. json= {"name":"name", "profile":"A", "login":"login", "password":"password"}
* http://localhost:9090/user (PUT) update. json= {"id":"1", "name":"name", "profile":"E", "login":"login", "password":"x", "version":"0"}
* http://localhost:9090/user/{id} (DELETE) delete by id
 

#### TODO
* update database properties in application.properties (main and test)
* implement internacionalization
