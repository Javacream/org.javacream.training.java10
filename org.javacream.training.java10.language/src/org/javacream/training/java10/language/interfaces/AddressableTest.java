package org.javacream.training.java10.language.interfaces;

import org.junit.Assert;
import org.junit.Test;

public class AddressableTest {

	@Test public void testPerson() {
		final String CITY = "M�nchen";
		final String STREET = "Marienplatz";
		Person p = new Person("Mustermann");
		Address address = new Address(CITY, STREET);
		p.setAddress(address);
		
		Assert.assertEquals(CITY, p.getCity());
		Assert.assertEquals(STREET, p.getStreet());
		
		Address toCompare = new Address("M�NChen", "marienplatz");
		Assert.assertTrue(p.compare(toCompare));
	}
}
