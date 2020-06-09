package ua.com.alevel.nix.experienceusingclass.hovorova.repository;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;

public interface MovieRepository extends AbstractRepository<Movie> {
	Movie findByFullName(String name);

	List<Movie> findByActor(String actorName);

	List<Movie> findByActorId(long id);
}