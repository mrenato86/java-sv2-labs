package schoolrecords.entiteswithvalidity;

public interface HasValidity {

    static void forArgumentNullity(String message, HasValidity... entities) {
        for (HasValidity entity : entities) {
            if (entity == null) {
                throw new NullPointerException(message);
            }
        }
    }

    static void forGeneralNullity(String message, Object o) {
        if (o == null) {
            throw new NullPointerException(message);
        }
    }

    static void forEmptiness(String message, String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }

}
