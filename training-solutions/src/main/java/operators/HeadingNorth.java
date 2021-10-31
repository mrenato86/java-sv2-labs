package operators;

public class HeadingNorth {

    public int getNumberOfNewDirections() {
        int degree = 0;
        int dirChange = 0;
        for (int i = 10; degree < 360; i += 10) {
            degree += i;
            dirChange++;
        }
        return dirChange;
    }

    public static void main(String[] args) {
        HeadingNorth hn = new HeadingNorth();
        System.out.println("Number of direction changes: " + hn.getNumberOfNewDirections());
    }

}
