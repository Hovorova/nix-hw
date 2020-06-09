package ua.com.alevel.nix.experienceusingclass.hovorova.service;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;

public interface MovieService extends AbstractService<Movie> {
	Movie findByFullName(String name);

	List<Movie> findByActor(String actorName);

	List<Movie> findByActorId(long id);
}