package schoolrecords.entiteswithvalidity;

public interface HasValidity {

    static void forArguments(String message, HasValidity... entities) {
        for (HasValidity entity : entities) {
            if (entity == null) {
                throw new NullPointerException(message);
            }
        }
    }

    static void forGeneralNullity(Object o) {
        if (o == null) {
            throw new NullPointerException("All arguments must be provided!");
        }
    }

    static void forNullity(HasValidity entity, String messagePrefix) {
        if (entity == null) {
            throw new NullPointerException(messagePrefix + " must not be null!");
        }
    }

    static void forEmptiness(String name) {
        forEmptiness(name, "Name");
    }

    static void forEmptiness(String name, String messagePrefix) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException(messagePrefix + " must not be empty!");
        }
    }

    private static boolean isEmpty(String value) {
        return value == null || value.isBlank();
    }

}
