# REST API NBD
## Docker
```
docker run --name [machine name] --network host -d -e CASSANDRA_LISTEN_ADDRES=[your docker ip] -e CASSANDRA_SEEDS=[your docker ip] cassandra:latest
```

## Import data.csv to cassandra
you must run application and create test keyspace before import data from csv file.
#### Copy file data.csv to docker
```
docker cp [data.csv path] [machine-name]:/[path]
```

####Run cqlsh
```
docker exec -it [machine-name] cqlsh
```

####Import data from CSV to cassandra
```aidl
COPY test.accidents FROM '[path-to-csv-file]' WITH DELIMITER=';' AND HEADER=TRUE;
```