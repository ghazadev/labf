package com.example.my_app.controller;

import com.example.my_app.entity.Person;
import com.example.my_app.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return repository.save(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }
}
