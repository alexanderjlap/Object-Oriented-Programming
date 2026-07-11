import java.util.LinkedList;

class MovieManager1 {
	
	MovieManager1() {}

	/**
	 * The purpose of this function is to take in each movie and check whether it is in a certain showtime
	 * @param movies
	 * @return this function will return a list of the different types of movies so starting from their times
	 */
	public Programme organizeMovies(LinkedList<Movie> movies) {
		LinkedList<Movie> matinee = new LinkedList<Movie>();
		LinkedList<Movie> primetime = new LinkedList<Movie>();
		LinkedList<Movie> soiree = new LinkedList<Movie>();

		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			if (movie.showtime > 700 && movie.showtime < 1200) {
				matinee.add(movie);

			} else if (movie.showtime > 1200 && movie.showtime < 2000) {
				primetime.add(movie);
			} else if (movie.showtime > 2000 || movie.showtime < 200) {
				soiree.add(movie);
			}
		}
		return new Programme(matinee, primetime, soiree);
	}
}
