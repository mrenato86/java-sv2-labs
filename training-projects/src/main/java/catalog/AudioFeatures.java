package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature {

    private final List<String> composer;
    private final int length;
    private final List<String> performers;
    private final String title;

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        validateArguments(title, length, performers, composer);
        this.title = title;
        this.length = length;
        this.performers = new ArrayList<>(performers);
        this.composer = new ArrayList<>(composer);
    }

    public AudioFeatures(String title, int length, List<String> performers) {
        this(title, length, performers, new ArrayList<>());
    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>(composer);
        contributors.addAll(performers);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    private void validateArguments(String title, int length, List<String> performers, List<String> composer) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title can't be empty!");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length can't be zero or negative!");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("Performer list can't be empty!");
        }
        if (composer == null) {
            throw new IllegalArgumentException("Composer list can't be null!");
        }
    }

}
