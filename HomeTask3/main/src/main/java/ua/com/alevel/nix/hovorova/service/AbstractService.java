package ua.com.alevel.nix.hovorova.service;

import ua.com.alevel.nix.hovorova.entity.AbstractData;
import ua.com.alevel.nix.hovorova.repository.Repository;

public abstract class AbstractService<T extends AbstractData> {
    private Repository<T> repository;

    public abstract T get(long id);
    public abstract long create(T obj);
    public abstract void update(T obj);
    public abstract void delete(T obj);

    public Repository<T> getRepository() {
        return repository;
    }

    public void setRepository(Repository<T> repository) {
        this.repository = repository;
    }
}
