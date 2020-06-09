package ua.com.alevel.nix.experienceusingclass.hovorova.repository;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.AbstractData;

public interface AbstractRepository<T extends AbstractData<T>> {

	void save(T t);

	T findById(long id);

	List<T> findAll();

	void update(T t);

	void remove(long id);
}
