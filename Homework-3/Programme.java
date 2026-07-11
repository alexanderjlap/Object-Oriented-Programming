import java.util.LinkedList;

class Programme {
	
	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;


	
	Programme()
	{
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}
	
	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree)
	{
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}

	/**
	 * The purpose of this function is to check wheather or not two movies are equal to each other depending on their category, if they are both soiree movies
	 * it will produce true. While if a soiree movie is compared to a matinee it will produce false since they are not the same show time of movie.
	 * @param obj
	 * @return this function returns if two movies are equal to each other
	 */
	@Override
	public boolean equals(Object obj) {
		System.out.print("Hi");
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;

		Programme programme = (Programme) obj;

		if(this.matinee.size() != programme.matinee.size()) {
			return false;
		}
		if(this.primetime.size() != programme.primetime.size()) {
			return false;
		}
		if(this.soiree.size() != programme.soiree.size()) {
			return false;
		}

		for (int i = 0; i < this.soiree.size(); i++) {
			Movie movie1= this.soiree.get(i);
			Movie movie2 = programme.soiree.get(i);
			if(movie1.showtime == movie2.showtime) {
				if(!movie1.title.equals(movie2.title)) {
					return false;
				}
			}
			else return false;
		}

		for (int i = 0; i < this.matinee.size(); i++) {
			Movie movie1= this.matinee.get(i);
			Movie movie2 = programme.matinee.get(i);
			if(movie1.showtime == movie2.showtime) {
				if(!movie1.title.equals(movie2.title)) {
					return false;
				}
			}

			else return false;
		}

		for (int i = 0; i < this.primetime.size(); i++) {
			Movie movie1= this.primetime.get(i);
			Movie movie2 = programme.primetime.get(i);
			if(movie1.showtime == movie2.showtime) {
				if(!movie1.title.equals(movie2.title)) {
					return false;
				}
			}
			else return false;
		}

		return true;
	}


}
