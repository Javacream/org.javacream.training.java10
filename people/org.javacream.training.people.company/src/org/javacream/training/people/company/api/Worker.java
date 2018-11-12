package org.javacream.training.people.company.api;

import org.javacream.training.people.base.types.api.Person;

public class Worker extends Person {

    private static final long serialVersionUID = 1L;

    public String getCompany() {
	return company;
    }

    public Worker(String lastname, String firstname, String company) {
	super(lastname, firstname);
	this.company = company;
    }

    private String company;

    @Override
    public String sayHello() {
	return super.sayHello() + " working at " + company;
    }

}
