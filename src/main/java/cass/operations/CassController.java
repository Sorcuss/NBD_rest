package cass.operations;

import java.util.ArrayList;
import java.util.List;

import data.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CassController {

    @Autowired
    CassRepository cassRepository;

    @GetMapping("/persons")
    private List<Person> getAll(){
        Iterable<Person> result = cassRepository.findAll();
        List<Person> persons = new ArrayList<Person>();
        result.forEach(persons::add);
        return persons;
    }
}
