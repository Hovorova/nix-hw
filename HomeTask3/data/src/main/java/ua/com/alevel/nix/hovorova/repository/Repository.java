package ua.com.alevel.nix.hovorova.repository;

import ua.com.alevel.nix.hovorova.entity.AbstractData;

import java.util.Collection;

public interface Repository<T extends AbstractData> {
    T get(long id);

    long create(T obj);

    void update(T obj);

    void delete(T obj);

    Collection<T> getAll();
}
