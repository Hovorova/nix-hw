package ua.com.alevel.nix.hovorova.repository;

import ua.com.alevel.nix.hovorova.entity.Actor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ActorRepository implements Repository<Actor> {
    private Map<Long, Actor> data = new HashMap<>();

    @Override
    public Actor get(long id) {
        return data.get(id);
    }

    @Override
    public long create(Actor obj) {
        long id = IdGenerator.nextId(data);
        obj.setId(id);
        data.put(id, obj);
        return id;
    }

    @Override
    public void update(Actor obj) {
        data.put(obj.getId(), obj);
    }

    @Override
    public void delete(Actor obj) {
        data.remove(obj.getId());
    }

    @Override
    public Collection<Actor> getAll() {
        return data.values();
    }

    private static class IdGenerator {
        private static long nextId(Map<Long, Actor> data) {
            return data.size() + 1;
        }
    }
}
