package algorithmscount;

public class Digits {

    public int getCountOfNumbers() {
        int count = 0;
        for (int i = 10; i < 100; i++) {
            int first = i / 10;
            int sec = i % 10;
            if (Math.abs(first - sec) == 5) {
                count++;
            }
        }
        return count;
    }

}
