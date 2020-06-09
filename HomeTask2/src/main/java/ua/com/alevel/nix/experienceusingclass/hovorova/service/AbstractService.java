package ua.com.alevel.nix.experienceusingclass.hovorova.service;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.AbstractData;

public interface AbstractService<T extends AbstractData<T>> {

	void saveOrUpdate(T t);

	T findById(long id);

	List<T> findAll();

	void remove(long id);
}
