package com.nbd.repositories;

import com.nbd.models.Accident;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AccidentRepository extends CassandraRepository<Accident, String> {
}
