package introexceptionthrow;

public class AdultContent {

    public static void main(String[] args) {
        Adult adult = new Adult("John Doe", 28);
        System.out.println(adult.getName());
        System.out.println(adult.getAge());

        Adult young = new Adult("Young Doe", 17);
        System.out.println(young.getName());
        System.out.println(young.getAge());
    }
}
