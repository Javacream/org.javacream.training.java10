package org.javacream.training.people.base.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;
import org.javacream.training.people.base.api.PeopleController;
import org.javacream.training.people.base.api.Person;


public class MapPeopleController implements PeopleController {

    private Map<Long, Person> people = new HashMap<>();
    @Override
    public void save(Person p) {
	people.put(p.getId(), p);
    }

    @Override
    public Collection<Person> findAll() {
	return SerializationUtils.clone(new ArrayList<>(people.values()));
    }

    @Override
    public Person findById(Long id) {
	return people.get(id);
    }

}
