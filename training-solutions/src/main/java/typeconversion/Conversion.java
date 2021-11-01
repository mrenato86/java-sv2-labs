package typeconversion;

public class Conversion {

    public double convertDoubleToDouble(double number) {
        return (int) number;
    }

    public byte[] convertIntArrayToByteArray(int[] numbers) {
        byte[] result = new byte[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = (0 <= numbers[i] && numbers[i] <= 127) ? (byte) numbers[i] : -1;
        }
        return result;
    }

    public int getFirstDecimal(double number) {
        return (int) ((number - (int) number) * 10);
    }

}
