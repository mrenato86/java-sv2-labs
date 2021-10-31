package enumtype.firstenum;

import java.util.Arrays;

public class FirstEnumMain {

    public static void main(String[] args) {

        for (Continent c : Continent.values()) {
            System.out.println(c);
        }
        System.out.println(Arrays.toString(Continent.values()));
        System.out.println();

        System.out.println(Ocean.valueOf("ATLANTIC"));
        System.out.println(Ocean.valueOf("PACIFIC"));
        System.out.println(Ocean.valueOf("INDIAN"));
        System.out.println(Ocean.valueOf("SOUTHERN"));
        System.out.println(Ocean.valueOf("ARCTIC"));
        System.out.println();

        for (Football f : Football.values()) {
            System.out.println(f.name());
        }

    }

}
