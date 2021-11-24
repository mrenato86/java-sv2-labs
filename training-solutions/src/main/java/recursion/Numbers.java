package recursion;

import java.util.Arrays;

public class Numbers {

    public int getSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        if (numbers.length > 1) {
            return numbers[0] + getSum(Arrays.copyOfRange(numbers, 1, numbers.length));

        } else {
            return numbers[0];
        }
    }

}
