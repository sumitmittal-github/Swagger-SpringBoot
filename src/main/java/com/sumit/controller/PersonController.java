package com.sumit.controller;

import com.sumit.domain.Person;
import com.sumit.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    @ApiOperation(value = "List all persons",
                  notes = "return list of all the persons from the backend server",
                  response = List.class
    )
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get person by Id",
            notes = "Provide an id to lookup specific Person object from backend system",
            response = Person.class)
    public Person getPersonById(@ApiParam(value = "ID value of the Person you want to retrieve", required = true) @PathVariable Long id){
        return personService.getPersonById(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Add person object",
            notes = "Add the person details in the backend system",
            response = Person.class)
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

}