package org.javacream.training.people.company.api;

import org.javacream.training.people.base.api.Person;

public class Worker extends Person{

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
