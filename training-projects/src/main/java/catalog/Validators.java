package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isEmpty(List<String> value) {
        return value == null || value.isEmpty();
    }

    public static boolean isEmptyArray(Object[] value) {
        return value == null || value.length == 0;
    }
}
