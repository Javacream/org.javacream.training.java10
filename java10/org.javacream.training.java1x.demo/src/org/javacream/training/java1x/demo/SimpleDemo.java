package org.javacream.training.java1x.demo;

import java.util.Arrays;
//import java.sql.Connection;
import java.util.HashSet;

import org.apache.commons.lang3.SerializationUtils;

public class SimpleDemo
{

	public static void main(String[] args) throws Exception
	{
		HashSet<String> names = new HashSet<>();
		names.add("Hugo");
		names.add("Emil");
		System.out.println("Hello Jigsaw!");
		//Connection con = null;
		SerializationUtils.clone(names);
		Class<?> clazz = Class.forName("java.sql.Connection");
		System.out.println(Arrays.asList(clazz.getDeclaredMethods()));
		
	}
}
