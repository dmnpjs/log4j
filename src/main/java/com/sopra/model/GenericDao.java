package com.sopra.model;

import java.util.List;

public interface GenericDao<T,K> {

	List<T> findAll();
	T findByKey (K id);
	T insert (T obj);
	void update(T obj);
	void deleteByKey (K key);
	
	
}
