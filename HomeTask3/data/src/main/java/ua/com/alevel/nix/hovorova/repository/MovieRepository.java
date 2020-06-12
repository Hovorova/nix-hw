package ua.com.alevel.nix.hovorova.repository;

import ua.com.alevel.nix.hovorova.entity.Movie;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MovieRepository implements Repository<Movie> {
    private Map<Long, Movie> data = new HashMap<>();
    @Override
    public Movie get(long id) {
        return data.get(id);
    }

    @Override
    public long create(Movie obj) {
        long id = IdGenerator.nextId(data);
        obj.setId(id);
        data.put(id, obj);
        return id;
    }

    @Override
    public void update(Movie obj) {
        data.put(obj.getId(), obj);
    }

    @Override
    public void delete(Movie obj) {
        data.remove(obj.getId());
    }

    @Override
    public Collection<Movie> getAll() {
        return data.values();
    }

    private static class IdGenerator {
        private static long nextId(Map<Long, Movie> data) {
            return data.size() + 1;
        }
    }
}
