package compositionlist;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> capsules = new ArrayList<>();

    public void addFirst(String capsule) {
        capsules.add(0, capsule);
    }

    public void addLast(String capsule) {
        capsules.add(capsule);
    }

    public void removeFirst() {
        capsules.remove(0);
    }

    public void removeLast() {
        capsules.remove(capsules.size() - 1);
    }

    public List<String> getColors() {
        return capsules;
    }

    public static void main(String[] args) {
        Capsules tube = new Capsules();
        tube.addLast("red");
        tube.addLast("white");
        tube.addFirst("green");
        System.out.println(tube.getColors());

        tube.removeFirst();
        tube.removeLast();
        System.out.println(tube.getColors());
    }

}
