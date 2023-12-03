package com.sumit.repository;

import com.sumit.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PersonRepository {

    public List<Person> loadAllPersonsFromDB(){
        return Arrays.asList(
            new Person(1L,"Sumit",  (byte) 35, "1122334455"),
            new Person(2L,"Lokesh", (byte) 37, "2233445566"),
            new Person(3L,"Alex",   (byte) 42, "3344556677"),
            new Person(4L,"Bob",   (byte) 29, "4455667788")
        );
    }

}