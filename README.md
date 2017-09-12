# springboot-rest-dellas

A simple Spring-Boot rest application with hibernate and criteria for consults per filter.

To run: 

mvn clean install

mvn spring-boot:run

Endpoints User

* http://localhost:9090/user/{id} (GET) get by id
* http://localhost:9090/user (GET) get all
* http://localhost:9090/user/?name=name&profile=E (GET) find by filter
* http://localhost:9090/user (POST) insert. json= {"name":"name", "profile":"A", "login":"login", "password":"password"}
* http://localhost:9090/user (PUT) update. json= {"id":"1", "name":"name", "profile":"E", "login":"login", "password":"x", "version":"0"}
* http://localhost:9090/user/{id} (DELETE) delete by id

Endpoints Product

* http://localhost:9090/product/{id} (GET) get by id
* http://localhost:9090/product (GET) get all
* http://localhost:9090/product/?expirationDate=12/09/2017&description=produto&unitaryValue=11.50&amount=200 (GET) find by filter
* http://localhost:9090/product (POST) insert. json=  {"description":"product", "unitaryValue":"3.5", "amount":"20", "expirationDate":"15/03/2017"}
* http://localhost:9090/product (PUT) update. json= {"id":"1", "description":"product updated", "unitaryValue":"11.5", "amount":"200", "expirationDate":"12/09/2017", "version":"0"}
* http://localhost:9090/product/{id} (DELETE) delete by id


#### TODO
* update database properties in application.properties (main and test)
* implement internacionalization
