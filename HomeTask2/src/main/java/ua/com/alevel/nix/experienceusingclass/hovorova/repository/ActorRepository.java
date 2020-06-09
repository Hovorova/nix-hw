package ua.com.alevel.nix.experienceusingclass.hovorova.repository;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;

public interface ActorRepository extends AbstractRepository<Actor> {
	Actor findByFullName(String name);

	List<Actor> findByMovie(String movieName);

	List<Actor> findByMovieId(long id);
}
