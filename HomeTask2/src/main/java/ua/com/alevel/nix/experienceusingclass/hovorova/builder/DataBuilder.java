package ua.com.alevel.nix.experienceusingclass.hovorova.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import ua.com.alevel.nix.experienceusingclass.hovorova.config.ApplicationEnvironment;
import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;
import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.ActorService;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.MovieService;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.impl.ActorServiceImpl;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.impl.MovieServiceImpl;

public class DataBuilder implements AbstractBuilder {

	private final ActorService actorService = new ActorServiceImpl();
	private final MovieService movieService = new MovieServiceImpl();

	@Override
	public void buildDataList() {
		for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties(
				ApplicationEnvironment.getPropertyLang()).entrySet()) {

			Movie movie = new Movie();
			String movieName = String.join(" ", entry.getKey().split("_"));
			movie.setName(movieName);

			List<Actor> actors = new ArrayList<>();
			if (entry.getValue().contains(",")) {
				List<String> actorsNames = Arrays.asList(entry.getValue().split(","));
				for (String name : actorsNames) {
					Actor actor = new Actor();
					actor.setName(name);
					actorService.saveOrUpdate(actor);
					actors.add(actorService.findByFullName(name));
				}
			} else {
				String name = entry.getValue();
				Actor actor = new Actor();
				actor.setName(name);
				actorService.saveOrUpdate(actor);
				actors.add(actorService.findByFullName(name));
			}

			movie.setActors(actors);
			movieService.saveOrUpdate(movie);
		}
		
		List<Actor> actors = actorService.findAll();
		for (Actor actor : actors) {
			List<Movie> actorMovies = new ArrayList<>();
			for (Movie movie : movieService.findAll()) {
				for (Actor movieActor : movie.getActors()) {
					if (movieActor.getName().equals(actor.getName())) {
						actorMovies.add(movie);
					}
				}
			}
			actor.setMovies(actorMovies);
			actorService.saveOrUpdate(actor);
		}

		for (Actor actor : actorService.findAll()) {
			StringBuilder movies = new StringBuilder();
			for(Movie movie : actor.getMovies()) {
				movies.append(movie.getName() + ", ");
			}
			System.out.println(actor.getName() + " starred in " + movies.substring(0, movies.length() - 2));
		}

		
		
	}

	public ActorService getActorService() {
		return actorService;
	}

	public MovieService getMovieService() {
		return movieService;
	}
}
