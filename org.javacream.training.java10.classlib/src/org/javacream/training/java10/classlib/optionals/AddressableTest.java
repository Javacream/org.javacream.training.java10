package org.javacream.training.java10.classlib.optionals;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class AddressableTest {

	@Test public void testPerson() {
		final String CITY = "München";
		final String STREET = "Marienplatz";
		Person p = new Person("Mustermann", Optional.of(new Address(CITY, STREET)));
		Assert.assertEquals(CITY, p.getCity());
		Assert.assertEquals(STREET, p.getStreet());
		Address toCompare = new Address("München", "Marienplatz");
		Assert.assertTrue(p.compare(toCompare));
	}
}
