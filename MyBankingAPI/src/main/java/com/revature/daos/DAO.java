package com.revature.daos;

import java.io.Serializable;
import java.util.List;

public interface DAO <T, I> extends Serializable {
	List<T> findAll();
	T findById(I id);
	T create(T obj);
	T update(T obj);

}
