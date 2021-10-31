package chars;

public class Whitespace {

    public String makeWhitespaceToStar(String text) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isWhitespace(chars[i])) {
                chars[i] = '*';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Whitespace whitespace = new Whitespace();
        String testStr = "This is an interesting\n test.";
        System.out.println(testStr);
        System.out.println(whitespace.makeWhitespaceToStar(testStr));
        System.out.println(testStr.replaceAll("\\s", "*"));
    }

}
