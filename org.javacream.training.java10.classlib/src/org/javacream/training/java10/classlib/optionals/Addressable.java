package org.javacream.training.java10.classlib.optionals;

import java.util.Optional;

public interface Addressable {
	static Address DEFAULT = new Address("unknown street", "unknown city");
	Optional<Address> getAddress();
	
	default String getCity() {
		return getAddress().orElse(DEFAULT).getCity();
	}
	default String getStreet() {
		return getAddress().orElse(DEFAULT).getStreet();
	}
	
	default boolean compare(Address toCompare) {
		return compareCityNormalized(toCompare.getCity()) && compareStreetNormalized(toCompare.getStreet());
	}
	
	private boolean compareCityNormalized(String city) {
		return city.toUpperCase().compareTo(getCity().toUpperCase()) == 0;
	}
	private boolean compareStreetNormalized(String street) {
		return street.toUpperCase().compareTo(getStreet().toUpperCase()) == 0;
	}
}
