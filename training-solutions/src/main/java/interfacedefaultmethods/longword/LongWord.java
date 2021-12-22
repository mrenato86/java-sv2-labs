package interfacedefaultmethods.longword;

import java.nio.file.Path;
import java.util.List;

public class LongWord implements FileOperations {

    private Path path;

    public LongWord(Path path) {
        this.path = path;
    }

    @Override
    public String getLongWord() {
        List<String> words = readFromFile(path);
        StringBuilder result = new StringBuilder(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            String actual = words.get(i);
            result.append(actual.charAt(actual.length() - 1));
        }
        return result.toString();
    }
}
