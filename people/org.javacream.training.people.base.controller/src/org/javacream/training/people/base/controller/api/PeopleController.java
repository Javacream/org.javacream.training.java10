package org.javacream.training.people.base.controller.api;

import java.util.Collection;

import org.javacream.training.people.base.controller.impl.MapPeopleController;
import org.javacream.training.people.base.controller.impl.PeopleControllerListenerDecorator;
import org.javacream.training.people.base.types.api.Person;

public interface PeopleController {

    void save(Person p);
    Collection<Person> findAll();
    Person findById(Long id);
    
    static PeopleController create() {
	MapPeopleController mapPeopleController = new MapPeopleController();
	PeopleControllerListenerDecorator peopleControllerListenerDecorator = new PeopleControllerListenerDecorator();
	peopleControllerListenerDecorator.setPeopleController(mapPeopleController);
	return peopleControllerListenerDecorator;
    }
}
