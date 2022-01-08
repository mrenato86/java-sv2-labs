package catalog;

public class SearchCriteria {

    private final String contributor;
    private final String title;

    private SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        validateArgument(title);
        validateArgument(contributor);
        return new SearchCriteria(title, contributor);
    }

    public static SearchCriteria createByContributor(String contributor) {
        validateArgument(contributor);
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByTitle(String title) {
        validateArgument(title);
        return new SearchCriteria(title, null);
    }

    public boolean hasContributor() {
        return contributor != null;
    }

    public boolean hasTitle() {
        return title != null;
    }

    public String getContributor() {
        return contributor;
    }

    public String getTitle() {
        return title;
    }

    private static void validateArgument(String argument) {
        if (Validators.isBlank(argument)) {
            throw new IllegalArgumentException("Parameter(s) must be provided!");
        }
    }
}
