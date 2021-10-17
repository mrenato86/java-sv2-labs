package classstructureattributes;

public class Song {

    String band, title;
    int length;

    @Override
    public String toString() {
        return  band + " - " + title + " (" + length + " min)";
    }
}
