package org.javacream.store.api;

import org.javacream.store.impl.SimpleStoreService;

public interface StoreService {
	int getStock(String category, String item);
	static StoreService create() {
	    return new SimpleStoreService();
	}
}
