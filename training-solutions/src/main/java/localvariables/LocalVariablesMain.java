package localvariables;

public class LocalVariablesMain {

    public static void main(String[] args) {

        //1.
        boolean b;
        //System.out.println(b);

        //2.
        b = false;
        System.out.println(b);

        //3.
        int a = 2;
        System.out.println(a);

        //4.
        int i = 3;
        int j = 4;

        //5.
        int k = i;

        //6.
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

        //7.
        //System.out.println(x);

        //8.
        String s = "Hello World!";
        System.out.println(s);

        //9.
        String t = s;
        System.out.println(t);

        /*String referencia próba
        System.out.println(t==s);
        System.out.println(t.equals(s));
        t="Hello World!  ".trim();
        System.out.println(t==s);
        System.out.println(t.equals(s));
        */

        //10.
        {
            int x = 0;
            System.out.println(x);

            System.out.println(a); //12.
        }

        //11.
        //System.out.println(x);
    }

}