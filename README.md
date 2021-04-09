# spring-microservices
## 1.0 - restful-web-services
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

## 2.0 - limits-service (starts on 8080 port)
- Read properties from configuration (Config class and application.properties)
- Connect Limits Service to Spring Cloud Config Server
- Configure profiles to read properties according to the profile

## 2.1 - spring-cloud-config-server (starts on 8888 port -> http://localhost:8888/limits-service/default)
- Read properties from file -> git-localconfig-repo project outside of this git repo
- Add properties for profiles (dev limits-service-dev.properties - qa limits-service-qa.properties)

## 3.0 - currency-exchange-service (starts on port 8000, 8001, 8002)
- Run with more instances (different ports) through -Dserver.port=<port> as VM arguments when run 
- Add h2 and jpa dependencies. Use a repository

## 3.1 - currency-conversion-service (starts on port 8100, 8101, 8102)
- Consume other service (currency-exchange-service) with RestTemplate
- Consume other service (currency-exchange-service) with FEIGN framework

## 3.2 - naming-server (starts on port 8761) -> http://localhost:8761
- Registre currency-exchange-service and currency-conversion-service in naming-service (eureka)
- Update proxy to avoid url hardcode and get balancer with eureka