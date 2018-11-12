package org.javacream.training.people.university.api;

import org.javacream.training.people.base.api.Person;

public class Student extends Person{

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
