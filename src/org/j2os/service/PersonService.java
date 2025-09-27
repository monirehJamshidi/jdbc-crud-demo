package org.j2os.service;

import org.j2os.entity.Person;
import org.j2os.repository.PersonDA;

import java.util.List;

public class PersonService {
    private static final PersonService PERSON_SERVICE = new PersonService();

    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }

    private PersonService(){}

    public void save(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.insert(person);
            personDA.commit();
        }
    }

    public void update(Person person) throws Exception{
        try (PersonDA personDA = new PersonDA()) {
            personDA.update(person);
            personDA.commit();
        }
    }

    public void delete(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()) {
            personDA.delete(person);
            personDA.commit();
        }
    }

    public List<Person> findAll() throws Exception{
        try (PersonDA personDA = new PersonDA()) {
            return personDA.selectAll();
        }
    }
}
