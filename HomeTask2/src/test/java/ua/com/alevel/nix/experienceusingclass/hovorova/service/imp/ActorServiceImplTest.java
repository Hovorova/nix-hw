package ua.com.alevel.nix.experienceusingclass.hovorova.service.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ua.com.alevel.nix.experienceusingclass.hovorova.data.Actor;
import ua.com.alevel.nix.experienceusingclass.hovorova.data.Movie;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.ActorService;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.MovieService;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.impl.ActorServiceImpl;
import ua.com.alevel.nix.experienceusingclass.hovorova.service.impl.MovieServiceImpl;

class ActorServiceImplTest {

	@Test
	void findByFullNameTest() {
		ActorService service = new ActorServiceImpl();
		Actor a1 = new Actor();
		a1.setName("Ivan");

		Actor a2 = new Actor();
		a2.setName("Masha");

		Actor a3 = new Actor();
		a3.setName("Dasha");

		service.saveOrUpdate(a1);
		service.saveOrUpdate(a2);
		service.saveOrUpdate(a3);

		Actor receivedActor = service.findByFullName(a2.getName());
		assertEquals(2L, receivedActor.getId());
		assertEquals(a2.getName(), receivedActor.getName());
	}

	@Test
	void findByMovieTest() {
		Movie m1 = new Movie();
		m1.setName("Movie1");
		Movie m2 = new Movie();
		m1.setName("Movie2");
		Movie m3 = new Movie();
		m1.setName("Movie3");

		Actor a1 = new Actor();
		a1.setName("Ivan");
		List<Movie> a1movies = Arrays.asList(new Movie[] { m1 });
		a1.setMovies(a1movies);

		Actor a2 = new Actor();
		a2.setName("Masha");
		List<Movie> a2movies = Arrays.asList(new Movie[] { m2, m3 });
		a2.setMovies(a2movies);

		Actor a3 = new Actor();
		a3.setName("Dasha");
		List<Movie> a3movies = Arrays.asList(new Movie[] { m1, m3 });
		a3.setMovies(a3movies);

		ActorService service = new ActorServiceImpl();
		service.saveOrUpdate(a1);
		service.saveOrUpdate(a2);
		service.saveOrUpdate(a3);

		List<Actor> receivedActors = service.findByMovie(m1.getName());
		assertTrue(receivedActors.get(0).getName().equals(a1.getName()));
		assertTrue(receivedActors.get(1).getName().equals(a3.getName()));
		assertEquals(2, receivedActors.size());
	}

	@Test
	void findByMovieIdTest() {
		MovieService movieService = new MovieServiceImpl();

		Movie m1 = new Movie();
		m1.setName("Movie1");
		movieService.saveOrUpdate(m1);
		m1 = movieService.findByFullName(m1.getName());

		Movie m2 = new Movie();
		m2.setName("Movie2");
		movieService.saveOrUpdate(m2);
		m2 = movieService.findByFullName(m2.getName());

		Movie m3 = new Movie();
		m3.setName("Movie3");
		movieService.saveOrUpdate(m3);
		m3 = movieService.findByFullName(m3.getName());

		Actor a1 = new Actor();
		a1.setName("Ivan");
		List<Movie> a1movies = Arrays.asList(new Movie[] { m1 });
		a1.setMovies(a1movies);

		Actor a2 = new Actor();
		a2.setName("Masha");
		List<Movie> a2movies = Arrays.asList(new Movie[] { m2, m3 });
		a2.setMovies(a2movies);

		Actor a3 = new Actor();
		a3.setName("Dasha");
		List<Movie> a3movies = Arrays.asList(new Movie[] { m1, m3 });
		a3.setMovies(a3movies);

		ActorService service = new ActorServiceImpl();
		service.saveOrUpdate(a1);
		service.saveOrUpdate(a2);
		service.saveOrUpdate(a3);

		List<Actor> receivedActors = service.findByMovieId(1);
		assertTrue(receivedActors.get(0).getName().equals(a1.getName()));
		assertTrue(receivedActors.get(1).getName().equals(a3.getName()));
		assertEquals(2, receivedActors.size());
	}

	@Test
	void saveOrUpdateTest() {
		ActorService service = new ActorServiceImpl();
		Actor a1 = new Actor();
		a1.setName("Ivan");

		assertNull(service.findByFullName(a1.getName()));
		service.saveOrUpdate(a1);
		assertEquals(a1.getName(), service.findByFullName(a1.getName()).getName());
		assertEquals(1, service.findByFullName(a1.getName()).getId());
		a1 = service.findByFullName(a1.getName());
		a1.setName("Updated");

		assertNull(service.findByFullName("Ivan"));
		assertEquals(1, service.findByFullName(a1.getName()).getId());
	}

	@Test
	void findByIdTest() {
		ActorService service = new ActorServiceImpl();
		Actor a1 = new Actor();
		a1.setName("Ivan");

		assertNull(service.findById(1));
		service.saveOrUpdate(a1);
		assertEquals("Ivan", service.findById(1).getName());
	}

	@Test
	void findAllTest() {
		ActorService service = new ActorServiceImpl();
		Actor a1 = new Actor();
		a1.setName("Ivan");

		Actor a2 = new Actor();
		a2.setName("Masha");

		Actor a3 = new Actor();
		a3.setName("Dasha");

		assertEquals(0, service.findAll().size());

		service.saveOrUpdate(a1);
		service.saveOrUpdate(a2);
		service.saveOrUpdate(a3);

		assertEquals(3, service.findAll().size());
	}

	@Test
	void removeTest() {

		ActorService service = new ActorServiceImpl();
		Actor a1 = new Actor();
		a1.setName("Ivan");

		Actor a2 = new Actor();
		a2.setName("Masha");

		Actor a3 = new Actor();
		a3.setName("Dasha");

		assertEquals(0, service.findAll().size());

		service.saveOrUpdate(a1);
		service.saveOrUpdate(a2);
		service.saveOrUpdate(a3);

		assertEquals(3, service.findAll().size());
		service.remove(2);
		assertEquals(2, service.findAll().size());

		for (Actor actor : service.findAll()) {
			if (actor.getName().equals(a2.getName())) {
				fail("Should be removed!");
			}
		}
	}

}
