package ua.com.alevel.nix.experienceusingclass.hovorova.service.impl;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;
import ua.com.alevel.nix.experienceusingclass.hovorova.repository.ActorRepository;
import ua.com.alevel.nix.experienceusingclass.hovorova.repository.impl.ActorRepositoryImpl;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.ActorService;

public class ActorServiceImpl implements ActorService {
	private final ActorRepository repository = new ActorRepositoryImpl();

	@Override
	public Actor findByFullName(String name) {
		return repository.findByFullName(name);
	}

	@Override
	public List<Actor> findByMovie(String movieName) {
		return repository.findByMovie(movieName);
	}

	@Override
	public List<Actor> findByMovieId(long id) {
		return repository.findByMovieId(id);
	}

	@Override
	public void saveOrUpdate(Actor actor) {
		if (actor.getId() == 0) {
			long id = findAll().size();
			actor.setId(++id);
			repository.save(actor);
		} else {
			repository.update(actor);
		}
	}

	@Override
	public Actor findById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Actor> findAll() {
		return repository.findAll();
	}

	@Override
	public void remove(long id) {
		repository.remove(id);
	}

}
