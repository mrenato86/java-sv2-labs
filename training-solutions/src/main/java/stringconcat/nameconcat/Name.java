package stringconcat.nameconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title = title;
    }

    public Name(String familyName, String middleName, String givenName) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
    }

    public Name(String familyName, String givenName) {
        this.familyName = familyName;
        this.givenName = givenName;
    }

    public Name(String familyName, String givenName, Title title) {
        this.familyName = familyName;
        this.givenName = givenName;
        this.title = title;
    }

    public String concatNameWesternStyle() {
        String result;

        if (title != null) {
            result = title.toString().concat(" ").concat(givenName).concat(" ");
        } else {
            result = givenName.concat(" ");
        }

        if (middleName != null) {
            result = result.concat(middleName).concat(" ");
        }

        result = result.concat(familyName);
        return result;
    }

    public String concatNameHungarianStyle() {
        String result;

        if (title != null) {
            result = title + " " + familyName + " ";
        } else {
            result = familyName + " ";
        }

        if (middleName != null) {
            result += middleName + " ";
        }

        result += givenName;
        return result;
    }

}
