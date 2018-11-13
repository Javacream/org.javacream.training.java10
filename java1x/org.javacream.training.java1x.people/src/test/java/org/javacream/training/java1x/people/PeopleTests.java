package org.javacream.training.java1x.people;

import java.util.Random;

import org.javacream.training.java1x.people.api.PeopleController;
import org.javacream.training.java1x.people.api.Person;
import org.junit.Test;

public class PeopleTests {

    @Test public void testPeopleController() {
	PeopleController peopleController = PeopleController.create();
	Random random = new Random(System.currentTimeMillis() + this.hashCode());
	for (Long i = 0l; i < 10; i++) {
	    var gender = Person.Gender.MALE;
	    var height = 170;
	    if (i%2 == 0) {
		gender = Person.Gender.FEMALE;
		height += i;
	    }else {
		height -= i;
	    }
	    var p = new Person(random.nextLong(), "lastname" + i, "firstname" + i, gender, height);
	    peopleController.save(p);
	}
	System.out.println(peopleController.findAll());
	System.out.println(peopleController.findAllAscending());
	System.out.println(peopleController.findAllDescending());
	
    }
}
