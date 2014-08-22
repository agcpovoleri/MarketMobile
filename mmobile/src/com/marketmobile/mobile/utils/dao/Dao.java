package com.marketmobile.mobile.utils.dao;

import java.util.List;

public interface Dao<T> {
	long save(T type);
	void update(T type);
	void delete(long id);
	T get(long id);
	List<T> getAll();
}
