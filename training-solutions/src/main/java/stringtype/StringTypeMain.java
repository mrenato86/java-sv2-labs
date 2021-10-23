package stringtype;

public class StringTypeMain {

    public static void main(String[] args) {

        //1.
        String prefix = "Hello ";
        //2.
        String name = "John Doe";
        //3.
        String message = prefix + name;
        System.out.println(message);
        //4.
        message = message + 444;

        //5.
        boolean b = message.equals("Hello John Doe");
        //6.
        boolean c = message.equals("Hello John Doe444");
        //7.
        System.out.println(prefix);
        System.out.println(name);
        System.out.println(message);
        System.out.println(b);
        System.out.println(c);

        //8.
        String empty = "" + "";
        System.out.println(empty);
        System.out.println(empty.length());

        //9.a.
        String word = "Abcde";
        System.out.println(word.length());
        //9.b.
        System.out.println(word.charAt(0) + ", " + word.charAt(2));
        //9.c.
        System.out.println(word.substring(0,3));


    }

}
