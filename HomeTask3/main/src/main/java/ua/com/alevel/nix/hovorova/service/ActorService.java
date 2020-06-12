package ua.com.alevel.nix.hovorova.service;

import ua.com.alevel.nix.hovorova.entity.Actor;

public final class ActorService extends AbstractService<Actor> {

    @Override
    public Actor get(long id) {
        return getRepository().get(id);
    }

    @Override
    public long create(Actor obj) {
        return getRepository().create(obj);
    }

    @Override
    public void update(Actor obj) {
        getRepository().update(obj);
    }

    @Override
    public void delete(Actor obj) {
        getRepository().delete(obj);
    }
}
