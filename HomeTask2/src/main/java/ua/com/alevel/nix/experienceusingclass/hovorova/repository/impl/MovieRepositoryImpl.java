package ua.com.alevel.nix.experienceusingclass.hovorova.repository.impl;

import java.util.ArrayList;
import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;
import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;
import ua.com.alevel.nix.experienceusingclass.hovorova.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {
	private List<Movie> movies = new ArrayList<>();

	@Override
	public Movie findByFullName(String name) {
		for (Movie movie : movies) {
			if (movie.getName().equals(name)) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<Movie> findByActor(String actorName) {
		List<Movie> result = new ArrayList<>();
		for (Movie movie : movies) {
			for (Actor actor : movie.getActors()) {
				if (actor.getName().equals(actorName)) {
					result.add(movie);
					break;
				}
			}
		}
		return result;
	}

	@Override
	public List<Movie> findByActorId(long id) {
		List<Movie> result = new ArrayList<>();
		for (Movie movie : movies) {
			for (Actor actor : movie.getActors()) {
				if (actor.getId() == id) {
					result.add(movie);
					break;
				}
			}
		}
		return result;
	}

	@Override
	public void save(Movie t) {
		movies.add(t);
	}

	@Override
	public Movie findById(long id) {
		for (Movie movie : movies) {
			if (movie.getId() == id) {
				return movie;
			}
		}
		return null;
	}

	@Override
	public List<Movie> findAll() {
		return movies;
	}

	@Override
	public void update(Movie t) {
		for (Movie movie : movies) {
			if (movie.getId() == t.getId()) {
				movie.setName(t.getName());
				movie.setActors(t.getActors());
				break;
			}
		}
	}

	@Override
	public void remove(long id) {
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getId() == id) {
				movies.remove(i);
				break;
			}
		}
	}

}
