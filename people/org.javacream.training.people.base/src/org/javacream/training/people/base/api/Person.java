package org.javacream.training.people.base.api;

import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    private static Long PEOPLE_COUNTER = 0l;
    private Long id;
    private String lastname;
    private String firstname;
    
    {
	PEOPLE_COUNTER++;
	id = PEOPLE_COUNTER;
    }
    public String sayHello() {
	return "Hello, my name is " + firstname + " " + lastname;
    }

    @Override
    public String toString() {
	return "Person [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Person other = (Person) obj;
	if (firstname == null) {
	    if (other.firstname != null)
		return false;
	} else if (!firstname.equals(other.firstname))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (lastname == null) {
	    if (other.lastname != null)
		return false;
	} else if (!lastname.equals(other.lastname))
	    return false;
	return true;
    }

    public Long getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Person(String lastname, String firstname) {
	super();
	this.lastname = lastname;
	this.firstname = firstname;
    }

}
