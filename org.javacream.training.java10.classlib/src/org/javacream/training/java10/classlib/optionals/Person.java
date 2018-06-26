package org.javacream.training.java10.classlib.optionals;

import java.util.Optional;

public class Person implements Addressable{
	private String name;
	private Optional<Address> address;
	public Person(String name, Optional<Address> address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Optional<Address> getAddress() {
		return address;
	}
	public void setAddress(Optional<Address> address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	
	

}
