package org.self.springbootredis.services;

import lombok.RequiredArgsConstructor;
import org.self.springbootredis.models.Person;
import org.self.springbootredis.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    public Person getPersonById(UUID id) {
        return personRepository.findById(id).orElse(Person.builder().build());
    }
}
