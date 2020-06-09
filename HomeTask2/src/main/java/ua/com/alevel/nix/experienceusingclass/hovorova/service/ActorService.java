package ua.com.alevel.nix.experienceusingclass.hovorova.service;

import java.util.List;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;

public interface ActorService extends AbstractService<Actor> {
	Actor findByFullName(String name);

	List<Actor> findByMovie(String movieName);

	List<Actor> findByMovieId(long id);

}
