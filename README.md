# ms-spring
Simple money convert application build with spring cloud microservices and run on docker.

## services included
- **Redis** - for caching.
- **Config server** - get configuration from github repository.
- **Consul discovery** - port 8500 instances health.
- **Resilience4J** - Circuit Breaker.
- **LoadBalancer** - between two instances.
- **Gateway** - port 8080.
- **Prometheus** - port 9090 for getting alerts.


## urls:
### Money convert:
http://localhost:8080/srva/convert?from=ILS&to=USD&amount=100

### Load balancer in action:
http://localhost:8080/srva/service/a

## To run the application from docker hub:
Get the docker-compose.yml file and run
>docker-compose up
