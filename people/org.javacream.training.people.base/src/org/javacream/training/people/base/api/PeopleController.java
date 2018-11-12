package org.javacream.training.people.base.api;

import java.util.Collection;

import org.javacream.training.people.base.impl.MapPeopleController;

public interface PeopleController {

    void save(Person p);
    Collection<Person> findAll();
    Person findById(Long id);
    
    static PeopleController create() {
	return new MapPeopleController();
    }
}
