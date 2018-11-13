package org.javacream.training.java1x.people.api;

public class Person {

    public Person(Long id, String lastname, String firstname, Gender gender, Integer height) {
	super();
	this.id = id;
	this.lastname = lastname;
	this.firstname = firstname;
	this.gender = gender;
	this.height = height;
    }

    @Override
    public String toString() {
	return "Person [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", gender=" + gender
		+ ", height=" + height + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    private Long id;
    private String lastname;
    private String firstname;
    private Gender gender;
    private Integer height;

    public static enum Gender{
	MALE, FEMALE;
    }
}
