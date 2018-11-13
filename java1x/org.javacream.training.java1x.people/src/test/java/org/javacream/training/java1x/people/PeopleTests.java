package org.javacream.training.java1x.people;

import java.util.Random;

import org.javacream.training.java1x.people.api.PeopleController;
import org.javacream.training.java1x.people.api.PeopleUtilities;
import org.javacream.training.java1x.people.api.Person;
import org.junit.Before;
import org.junit.Test;

public class PeopleTests {

    private PeopleController peopleController;
    @Before public void init() {
	peopleController = PeopleController.create();
	Random random = new Random(System.currentTimeMillis() + this.hashCode());
	for (Long i = 10l; i < 20; i++) {
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
	for (Long i = 0l; i < 10; i++) {
	    var gender = Person.Gender.MALE;
	    var height = 170;
	    if (i%2 == 0) {
		gender = Person.Gender.FEMALE;
		height += i;
	    }else {
		height -= i;
	    }
	    var p = new Person(i, "lastname" + i, "firstname" + i, gender, height);
	    peopleController.save(p);
	}
	
    }
    //@Test 
    public void testPeopleController() {
	System.out.println(peopleController.findAll());
	System.out.println(peopleController.findAllAscending());
	System.out.println(peopleController.findAllDescending());
	
    }

    @Test 
    public void testPeopleMatchAlgorithm() {
	System.out.println(PeopleUtilities.namesByHeightRange(175, 181, peopleController.findAll().stream()));
	System.out.println(PeopleUtilities.namesByHeightRange(175, 181, peopleController.findById(6l).stream()));
	
    }

}
