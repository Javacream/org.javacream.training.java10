package org.javacream.training.people.actor;

import org.javacream.training.people.base.api.PeopleController;
import org.javacream.training.people.base.api.Person;
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
	
   }
}
