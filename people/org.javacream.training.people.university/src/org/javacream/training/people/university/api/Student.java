package org.javacream.training.people.university.api;

import org.javacream.training.people.base.types.api.Person;

public class Student extends Person {

    private static final long serialVersionUID = 1L;
    private String university;

    @Override
    public String toString() {
	return "Student [university=" + university + ", toString()=" + super.toString() + "]";
    }

    @Override
    public String sayHello() {
	return super.sayHello() + " studying at " + university;
    }

    public String getUniversity() {
	return university;
    }

    public Student(String lastname, String firstname, String university) {
	super(lastname, firstname);
	this.university = university;
    }
}
