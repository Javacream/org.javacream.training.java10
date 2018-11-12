package org.javacream.training.people.actor;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.javacream.training.people.base.controller.api.PeopleController;
import org.javacream.training.people.base.types.api.Person;
import org.javacream.training.people.company.api.Worker;
import org.javacream.training.people.university.api.Student;

public class PeopleActor {

    public static void main(String[] args) {
	Person p = new Person("Sawitzki", "Rainer");
	Student s = new Student("Einstein", "Albert", "LMU");
	Worker w = new Worker("Schufter", "Hannes", "Integrata");
	PeopleController controller = PeopleController.create();
	controller.save(p);
	controller.save(s);
	controller.save(w);
	System.out.println(controller.findAll());
	System.out.println(controller.findById(2l));
	System.out.println(SerializationUtils.clone(p));
	System.out.println(ConcurrentUtils.class);
   }
}
