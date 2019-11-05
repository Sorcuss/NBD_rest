package cass.operations;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


import data.Person;

@Repository
public interface CassRepository extends CassandraRepository<Person, Integer> {
}
