package ua.com.alevel.nix.experienceusingclass.hovorova.repository.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;
import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;
import ua.com.alevel.nix.experienceusingclass.hovorova.repository.ActorRepository;

public class ActorRepositoryImpl implements ActorRepository {
	private final List<Actor> actors = new ArrayList<>();

	@Override
	public Actor findByFullName(String name) {
		for (Actor actor : actors) {
			if (actor.getName().equals(name)) {
				return actor;
			}
		}
		return null;
	}

	@Override
	public List<Actor> findByMovie(String movieName) {
		List<Actor> result = new ArrayList<>();
		for (Actor actor : actors) {
			for (Movie movie : actor.getMovies()) {
				if (movieName.equals((movie.getName()))) {
					result.add(actor);
				}
			}
		}
		return result;
	}

	@Override
	public List<Actor> findByMovieId(long id) {
		List<Actor> result = new ArrayList<>();
		for (Actor actor : actors) {
			for (Movie movie : actor.getMovies()) {
				if (movie.getId() == id) {
					result.add(actor);
				}
			}
		}
		return result;
	}

	public void save(Actor t) {
		actors.add(t);
	}

	public Actor findById(long id) {
		for (Actor actor : actors) {
			if (actor.getId() == id) {
				return actor;
			}
		}
		return null;
	}

	public List<Actor> findAll() {
		return actors;
	}

	public void update(Actor actorToUpdate) {
		for (Actor actor : actors) {
			if (actor.getId() == actorToUpdate.getId()) {
				actor.setName(actorToUpdate.getName());
				actor.setMovies(actorToUpdate.getMovies());
				break;
			}
		}
	}

	public void remove(long id) {
		for (int i = 0; i < actors.size(); i++) {
			if (actors.get(i).getId() == id) {
				actors.remove(i);
			}
		}
	}

}
