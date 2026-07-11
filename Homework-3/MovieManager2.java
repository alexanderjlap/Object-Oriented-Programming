import sun.awt.image.ImageWatched;

import java.util.LinkedList;

class MovieManager2 {
	
	MovieManager2() {}

	/**
	 * This function will organize the movies depending on their show times
	 * each type of movie will fall into matinee, primetime, or soiree
	 * @param movies
	 * @return the type of program it is
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {
		Programme programme = new Programme();
		for (Movie movie : movies) {
			if (!movie.simulcast) {
				if (movie.showtime >= 2000 || movie.showtime < 200) {
					programme.soiree.add(movie);
				} else if (movie.showtime >= 1200) {
					programme.primetime.add(movie);
				} else programme.matinee.add(movie);
			}
		}
		return programme;
	}
}