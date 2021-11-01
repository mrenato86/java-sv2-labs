package conversions;

import java.util.ArrayList;
import java.util.List;

public class Digits {

    private List<Integer> numbers = new ArrayList<>();

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addDigitsToList(String text) {
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(Integer.parseInt(String.valueOf(c)));
            }
        }
    }

    public static void main(String[] args) {
        Digits digits = new Digits();

        digits.addDigitsToList("d2fat674ghk73g1");
        System.out.println(digits.getNumbers());
    }
}
