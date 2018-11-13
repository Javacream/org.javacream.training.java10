package org.javacream.training.java1x.people.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.javacream.training.java1x.people.api.PeopleController;
import org.javacream.training.java1x.people.api.Person;

public class MapPeopleController implements PeopleController {

    private Map<Long, Person> people = new HashMap<>();
    @Override
    public void save(Person person) {
	people.put(person.getId(), person);
    }

    @Override
    public void update(Person person) {
	people.put(person.getId(), person);
    }

    @Override
    public Optional<Person> findById(Long id) {
	return Optional.ofNullable(people.get(id));
    }

    @Override
    public void deleteById(Long id) {
	people.remove(id);
    }

    @Override
    public Collection<Person> findAll() {
	return people.values();
    }

}
