package looptypesmodify;

import java.util.Arrays;

public class EveryThird {

    public int[] changeToZero(int[] numbers) {
        int[] result = numbers; //int[] result = Arrays.copyOf(numbers, numbers.length);
        for (int i = result.length - 1; i >= 0; i -= 3) {
            result[i] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        EveryThird everyThird = new EveryThird();
        //int[] data = {2, 6, 3, 5, 7, 2, 6, 2, 3, 5, 7, 3, 2, 9};
        //int[] result = everyThird.changeToZero(data);
        int[] result = everyThird.changeToZero(new int[]{2, 6, 3, 5, 7, 2, 6, 2, 3, 5, 7, 3, 2, 9});

        //System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(result));
    }

}
