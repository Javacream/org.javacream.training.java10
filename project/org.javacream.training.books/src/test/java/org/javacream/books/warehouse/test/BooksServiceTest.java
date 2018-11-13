package org.javacream.books.warehouse.test;

import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.javacream.books.warehouse.impl.MapBooksService;
import org.javacream.store.api.StoreService;
import org.junit.Test;


public class BooksServiceTest {

	@Test
	public void testBusinessObjects() throws Exception{
		MapBooksService mapBooksService = new MapBooksService();
		RandomIsbnGenerator randomIsbnGenerator = new RandomIsbnGenerator();
		randomIsbnGenerator.setCountryCode("-de");
		mapBooksService.setIsbnGenerator(randomIsbnGenerator);
		mapBooksService.setStoreService(StoreService.create());
		randomIsbnGenerator.setPrefix("TEST:");
		System.out.println(Class.forName("org.javacream.store.api.StoreService"));
		System.out.println(Class.forName("org.javacream.store.impl.SimpleStoreService"));
		TestActor.doTest(mapBooksService);
		
	
	}

	

}
