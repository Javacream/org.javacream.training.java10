package org.javacream.books.warehouse.test;

import org.javacream.store.impl.SimpleStoreService;
import org.junit.Assert;
import org.junit.Test;

public class StoreServiceTest
{

	@Test
	public void testBusinessObjects()
	{
		final int STOCK = 42;
		SimpleStoreService simpleStoreService = new SimpleStoreService();
		simpleStoreService.setStock(STOCK);
		int result = simpleStoreService.getStock("cat", "id");
		Assert.assertEquals(STOCK, result);
	}

}
