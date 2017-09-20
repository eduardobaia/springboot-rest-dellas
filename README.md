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
* http://localhost:9090/product/?http://localhost:9090/product/?expirationDate=15/03/2017&description=product1&unitaryValue=3.5&amount=20&statusIndicator=A (GET) find by filter
* http://localhost:9090/product (POST) insert. json=  {"description": "product test 1", "unitaryValue": 3.5, "expirationDate": "15/03/2017", "stockProductDTO":{"amount": 20, "statusIndicator": "A"}}
* http://localhost:9090/product (PUT) update. json= {"id":"1", "version":"0", "description":"product updated", "unitaryValue": "10.1", "expirationDate": "20/09/2017", "stockProductDTO":{"id":"1", "version":"0", "amount": 60, "statusIndicator": "A"}}
* http://localhost:9090/product/{id} (DELETE) delete by id

Endpoints Purchase
* http://localhost:9090/purchase/{id} (GET) get by id
* http://localhost:9090/purchase (GET) get all
* http://localhost:9090/purchase/?datePurchase=12/09/2017&discount=10.5&totalValue=100&amount=200 (GET) find by filter
* http://localhost:9090/purchase (POST) insert. json= {"datePurchase":"15/09/2017", "discount":"0", "totalValue":"200", "user":{"id":"1", "name":"name", "profile":"E", "login":"login", "password":"x", "version":"0"}, "products":[{"id":"1", "description":"product updated", "unitaryValue":"11.5", "amount":"200", "expirationDate":"12/09/2017", "version":"0"}, {"id":"2", "description":"product updated", "unitaryValue":"11.5", "amount":"200", "expirationDate":"12/09/2017", "version":"0"}]}
* http://localhost:9090/purchase (PUT) update. json= {"id":"1", "datePurchase":"15/09/2017", "discount":"0", "totalValue":"200", "version":"0", "user":{"id":"1", "name":"name", "profile":"E", "login":"login", "password":"x", "version":"0"}, "products":[{"id":"1", "description":"product updated", "unitaryValue":"11.5", "amount":"200", "expirationDate":"12/09/2017", "version":"0"}, {"id":"2", "description":"product updated", "unitaryValue":"11.5", "amount":"200", "expirationDate":"12/09/2017", "version":"0"}]}
* http://localhost:9090/purchase/{id} (DELETE) delete by id


#### TODO
* update database properties in application.properties (main and test)
* implement internacionalization
