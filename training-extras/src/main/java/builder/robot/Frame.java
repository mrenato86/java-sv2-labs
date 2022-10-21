package builder.robot;

public class Frame {

    private final byte[] bytes;

    public Frame(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String toHexString() {
        StringBuilder result = new StringBuilder();

        for (byte b : bytes) {
            if (result.length() != 0) {
                result.append("-");
            }
            String str = Integer.toHexString(0xFF & b);
            if (str.length() == 1) {
                str = "0" + str;
            }
            result.append(str);
        }
        return result.toString().toUpperCase();
    }

}
