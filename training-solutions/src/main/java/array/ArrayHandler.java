package array;

public class ArrayHandler {

    public void addIndexToNumber(int[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] += i;
        }
    }

    public void concatenateIndexToWord(String[] source) {
        for (int i = 0; i < source.length; i++) {
            source[i] = i + ". " + source[i];
        }
    }

    public static void main(String[] args) {
        ArrayHandler arrayHandler = new ArrayHandler();

        int[] numbers = {2, 4, 10, 22, 40};
        String[] cities = {"New York", "Boston", "Paris", "London" };

        arrayHandler.addIndexToNumber(numbers);
        arrayHandler.concatenateIndexToWord(cities);

        String outputWithNewLine = "";
        String outputWithComma = "";

        for (int num : numbers) {
            outputWithNewLine += num + "\n";
            outputWithComma += num + ", ";
        }
        System.out.print(outputWithNewLine);
        System.out.println(outputWithComma);

        outputWithNewLine = "";
        outputWithComma = "";

        for (String city : cities) {
            outputWithNewLine += city + "\n";
            outputWithComma += city + ", ";
        }
        System.out.print(outputWithNewLine);
        System.out.println(outputWithComma);
    }

}
