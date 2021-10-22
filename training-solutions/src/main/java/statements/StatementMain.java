package statements;

public class StatementMain {

    public static void main(String[] args) {
        //1.
        int x = 5 + 6;
        //2.
        int y = 11 - x;
        //3.
        int z = 8;
        //4.
        boolean b = x > y;
        //5.
        boolean c = b || (z > 5);
        //6.
        z++;
        //7.
        System.out.println("x: "+x);
        System.out.println("y: "+y);
        System.out.println("z: "+z);
        System.out.println("b: "+b);
        System.out.println("c: "+c);


    }

}
