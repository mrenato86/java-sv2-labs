package searching;

import java.util.Arrays;

public class Mountain {

    private final int[] pikesOrdered;

    public Mountain(int[] pikesOrdered) {
        this.pikesOrdered = pikesOrdered;
    }

    public int[] getPikesOrdered() {
        return pikesOrdered;
    }

    public boolean searchPike(Pike pike) {
        return Arrays.binarySearch(pikesOrdered, pike.getPikeHeight()) >= 0;
    }

}
