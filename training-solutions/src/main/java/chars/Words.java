package chars;

public class Words {

    public String pushWord(String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i]++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Words words = new Words();
        System.out.println(words.pushWord("alma"));

    }

}
