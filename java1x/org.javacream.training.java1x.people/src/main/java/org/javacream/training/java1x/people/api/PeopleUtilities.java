package org.javacream.training.java1x.people.api;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeopleUtilities {

    public static List<String> namesByHeightRange(int minHeight, int maxHeight, Stream<Person> people) {
	return people.filter((p) -> ((p.getHeight() >= minHeight) && (p.getHeight() <= maxHeight)))
		.sorted((p1, p2) -> p1.getLastname().compareTo(p2.getLastname()))
		.map((p) -> p.getFirstname() + " " + p.getLastname()).collect(Collectors.toList());
    }
}
