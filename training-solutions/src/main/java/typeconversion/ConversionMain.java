package typeconversion;

import java.util.Arrays;

public class ConversionMain {

    public static void main(String[] args) {

        Conversion conversion = new Conversion();
        System.out.println(conversion.convertDoubleToDouble(33.432));

        int[] numbers = {5, -14, 6, 2, 125, 354, 9738, 3};
        System.out.println(Arrays.toString(conversion.convertIntArrayToByteArray(numbers)));

        System.out.println(conversion.getFirstDecimal(3452.9765));

    }

}
