package ua.com.alevel.nix.hovorova;

import ua.com.alevel.nix.hovorova.entity.Actor;
import ua.com.alevel.nix.hovorova.repository.MovieRepository;
import ua.com.alevel.nix.hovorova.repository.Repository;
import ua.com.alevel.nix.hovorova.service.AbstractService;
import ua.com.alevel.nix.hovorova.service.ActorService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Repository<Actor> anonRepo = new Repository<>() {
			private static final String PREFIX = "actor:";
			private Map<String, Actor> data = new HashMap<>();

			@Override
			public Actor get(long id) {
				return data.get(PREFIX + id);
			}

			@Override
			public long create(Actor obj) {
				long id = data.size() + 1;
				obj.setId(id);
				data.put(PREFIX + id, obj);
				return id;
			}

			@Override
			public void update(Actor obj) {
				data.put(PREFIX + obj.getId(), obj);
			}

			@Override
			public void delete(Actor obj) {
				data.remove(PREFIX + obj.getId());
			}

			@Override
			public Collection<Actor> getAll() {
				return data.values();
			}
		};

		AbstractService<Actor> actorService = new ActorService();
		actorService.setRepository(anonRepo);

		Actor actor = new Actor();
		actor.setName("lui de funes");
		long id = actorService.create(actor);
		System.out.println(actorService.get(id).getName());

	}
}