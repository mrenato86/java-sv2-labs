package exceptionmulticatch.converter;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryLine) {
        if (binaryLine == null)
            throw new NullPointerException("Binary string is null.");
        if (binaryLine.isBlank())
            throw new IllegalArgumentException("Binary string is empty.");
        boolean[] result = new boolean[binaryLine.length()];
        for (int i = 0; i < binaryLine.length(); i++) {
            char actual = binaryLine.charAt(i);
            if (actual != '1' && actual != '0') {
                throw new IllegalArgumentException("Binary string is not valid.");
            }
            result[i] = actual == '1';
        }
        return result;
    }

    public String booleanArrayToBinaryString(boolean[] boolArray) {
        if (boolArray == null)
            throw new NullPointerException("Boolean array is null.");
        if (boolArray.length == 0)
            throw new IllegalArgumentException("Boolean array is empty.");
        StringBuilder sb = new StringBuilder(boolArray.length);
        for (boolean element : boolArray) {
            sb.append(element ? '1' : '0');
        }
        return sb.toString();
    }
}
