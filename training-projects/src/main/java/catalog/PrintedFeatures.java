package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {

    private final List<String> authors;
    private final int numberOfPages;
    private final String title;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        validateArguments(title, numberOfPages, authors);
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = new ArrayList<>(authors);
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public List<String> getContributors() {
        return new ArrayList<>(authors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    private void validateArguments(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Number of Pages can't be zero or negative!");
        }
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("Author list can't be empty!");
        }
    }
}
