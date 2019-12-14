package org.self.springbootredis.controllers;

import lombok.RequiredArgsConstructor;
import org.self.springbootredis.models.Person;
import org.self.springbootredis.services.PersonService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPerson() {
        return personService.getAllPerson();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Cacheable(value = "persons", key = "#id")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id);
    }
}
