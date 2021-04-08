# spring-microservices
## 01 - restful-web-services
- Basic endpoints (get-post)
- Return URI when create
- Handle exceptions
- Valiadtions
- HATEOAS -> Hypermedia As The Engine Of Application State (EntityModel). 
This is done by including links in a returned response and using only these links to further communicate with the server
- Internationalization
- Accept xml as request and response just using jackson-dataformat-xml dependency
- Swagger:
-> http://localhost:8080/v2/api-docs 
-> http://localhost:8080/swagger-ui.html (pending verify it works)
- Swagger documentation
- Actuator
-> http://localhost:8080/actuator 
-> http://localhost:8080/  (actuator UI)
- Static filtering (@JsonIgnore and @JsonIgnoreProperties)
- Dynamic filtering (@JsonFilte)
- Versioning (Basic approach)
- Versioning (through params)
- Versioning (through headers)
- Versioning (through producers)
- Basic authentication (default username = user and the password is generated and we can see it in the log when start). We can configure username and password in the application.properties
- Spring security (Basic authentication)
- H2 configuration
- Creating repository to connect resource with H2 DB
- Create User (one to many) post relation and resources

## 02 - limits-service
- Read properties from configuration (Config class and application.properties)
 