package org.javacream.training.people.base.controller.impl;

import java.util.Collection;
import java.util.ServiceLoader;

import org.javacream.training.people.base.controller.api.PeopleController;
import org.javacream.training.people.base.types.api.Person;
import org.javacream.training.people.listener.api.PeopleListener;

public class PeopleControllerListenerDecorator implements PeopleController {

    private PeopleController peopleController;
    private ServiceLoader<PeopleListener> listeners;
    
    {
	listeners = ServiceLoader.load(PeopleListener.class); 
    }
    
    public void setPeopleController(PeopleController peopleController) {
        this.peopleController = peopleController;
    }

    @Override
    public void save(Person p) {
	listeners.forEach((listener) -> listener.handleSave(p));
	peopleController.save(p);
    }

    @Override
    public Collection<Person> findAll() {
	return peopleController.findAll();
    }

    @Override
    public Person findById(Long id) {
	return peopleController.findById(id);
    }

}
