package algorithmsfilter.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VideoThequeTest {

    VideoTheque videoTheque = new VideoTheque();

    @BeforeEach
    void init() {
        videoTheque.addMovie(new Movie("Titanic", Category.ROMANTIC, 3));
        videoTheque.addMovie(new Movie("Frozen", Category.ANIMATION, 4));
        videoTheque.addMovie(new Movie("The Lord of the Rings", Category.FANTASY, 5));
        videoTheque.addMovie(new Movie("The Lion King", Category.ANIMATION, 5));
        videoTheque.addMovie(new Movie("Garfield", Category.ANIMATION, 2));
        videoTheque.addMovie(new Movie("Shrek", Category.ANIMATION, 5));
        videoTheque.addMovie(new Movie("Mission: Impossible", Category.ACTION, 5));
    }

    @Test
    void testGetGoodMoviesWithCategoryGiven() {
        List<Movie> expected = List.of(
                videoTheque.getMovies().get(1),
                videoTheque.getMovies().get(3),
                videoTheque.getMovies().get(5)
        );
        List<Movie> filtered = videoTheque.getGoodMoviesWithCategoryGiven(Category.ANIMATION);

        assertEquals(3, filtered.size());
        assertEquals(expected, filtered);
    }

    @Test
    void testGetGoodMoviesWithCategoryGivenNoResult() {
        List<Movie> filtered = videoTheque.getGoodMoviesWithCategoryGiven(Category.POLITICAL);

        assertEquals(0, filtered.size());
    }

}