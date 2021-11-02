package stringseparate;

import java.util.ArrayList;
import java.util.List;

public class Codes {

    public String getCodesStartWithLetter(List<String> codes) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String code : codes) {
            if (Character.isAlphabetic(code.charAt(0))) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(code);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Codes codes = new Codes();
        List<String> codeList = new ArrayList<>(List.of("8GVHd", "T57fbj", "57f8GVHd", "5T7fbj", "xtcu45", "f578GVHd"));

        System.out.println(codes.getCodesStartWithLetter(codeList));
    }

}
