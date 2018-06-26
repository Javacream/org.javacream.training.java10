package org.javacream.training.java10.language.functional;

public class ComplexStringTransformer implements StringTransformerAlgorithm {

	@Override
	public String transform(String input) {
		return new StringBuilder(input).reverse().toString().toUpperCase();
	}

}
