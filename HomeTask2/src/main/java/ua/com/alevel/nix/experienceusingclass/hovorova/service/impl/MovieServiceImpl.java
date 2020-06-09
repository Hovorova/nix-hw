package ua.com.alevel.nix.experienceusingclass.hovorova.service.impl;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;
import ua.com.alevel.nix.experienceusingclass.hovorova.repository.MovieRepository;
import ua.com.alevel.nix.experienceusingclass.hovorova.repository.impl.MovieRepositoryImpl;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.MovieService;

public class MovieServiceImpl implements MovieService {
	private final MovieRepository repository = new MovieRepositoryImpl();

	@Override
	public Movie findByFullName(String name) {
		return repository.findByFullName(name);
	}

	@Override
	public List<Movie> findByActor(String actorName) {
		return repository.findByActor(actorName);
	}

	@Override
	public List<Movie> findByActorId(long id) {
		return repository.findByActorId(id);
	}

	@Override
	public Movie findById(long id) {
		return repository.findById(id);
	}

	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public void remove(long id) {
		repository.remove(id);
	}

	@Override
	public void saveOrUpdate(Movie movie) {
		if (movie.getId() == 0) {
			long id = findAll().size();
			movie.setId(++id);
			repository.save(movie);
		} else {
			repository.update(movie);
		}
	}

}
