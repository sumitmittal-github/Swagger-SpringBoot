package com.sumit.service;

import com.sumit.domain.Person;
import com.sumit.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    private static Map<Long, Person> personMap = new HashMap<>();

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    private void test(){
        personRepository.loadAllPersonsFromDB().stream().forEach(p -> personMap.put(p.getId(), p));
    }


    public Person getPersonById(Long id){
        return personMap.get(id);
    }

    public List<Person> getAllPersons() {
        return new ArrayList<Person>(personMap.values());
    }

    public Person addPerson(Person person){
        personMap.put(person.getId(), person);
        return person;
    }



}
