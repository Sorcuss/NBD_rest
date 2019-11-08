# REST API NBD
## Docker
```
docker run --name [machine name] --network host -d -e CASSANDRA_LISTEN_ADDRES=[your docker ip] -e CASSANDRA_SEEDS=[your docker ip] cassandra:latest
```