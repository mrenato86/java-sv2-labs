package methodpass;

public class One {

    public int addOne(int number) {
        return ++number;
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println(number);

        number++;
        System.out.println(number);

        System.out.println(new One().addOne(number));
        System.out.println(number);
    }

}
