package org.javacream.training.java10.classlib.optionals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class OptionalStreamingTest {

	@Test public void doOptionalStreamingTest() {
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			people.add(new Person("Name" + i, Optional.of(new Address("City" + i, "Street" + i))));
		}
		for (int i = 0; i < 5; i++) {
			people.add(new Person("Name" + i, Optional.empty()));
		}
		
		System.out.println(people.stream().count());
		System.out.println(people.stream().filter((p) -> p.getAddress().isPresent()).count());
		people.stream().map((p) -> p.getAddress()).filter((a) -> a.isPresent()).map((a) -> a.get().getCity()).forEach((s) -> System.out.println(s.toLowerCase()));
		
	}
}
