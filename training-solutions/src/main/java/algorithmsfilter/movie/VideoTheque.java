package algorithmsfilter.movie;

import java.util.ArrayList;
import java.util.List;

public class VideoTheque {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> getGoodMoviesWithCategoryGiven(Category category) {
        List<Movie> filteredMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCategory() == category && movie.getRating() > 3) {
                filteredMovies.add(movie);
            }
        }
        return filteredMovies;
    }

}
