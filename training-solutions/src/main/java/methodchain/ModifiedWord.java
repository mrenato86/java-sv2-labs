package methodchain;

public class ModifiedWord {

    public String modify(String word) {
        return new StringBuilder()
                .append(Character.toUpperCase(word.charAt(0)))
                .append("x")
                .append(Character.toUpperCase(word.charAt(2)))
                .append("y")
                .toString();
    }
}
