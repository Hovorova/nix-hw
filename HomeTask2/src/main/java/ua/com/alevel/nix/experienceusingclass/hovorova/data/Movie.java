package ua.com.alevel.nix.experienceusingclass.hovorova.data;

import java.util.List;

public class Movie extends AbstractData<Movie> {
	private String name;
	private List<Actor> actors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
}
