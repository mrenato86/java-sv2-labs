package math.math;

public class MathMethods {

    public static void main(String[] args) {

        //1.
        System.out.println(Math.max(34, 45));
        //2.
        System.out.println(Math.min(34, 45));
        //3.
        System.out.println(Math.PI);
        //4.
        System.out.println(Math.round(Math.PI));
        //5.
        System.out.println(Math.round(23.456));
        System.out.println(Math.round(-23.56));
        //6.
        System.out.println(Math.abs(-23.456));
        System.out.println(Math.abs(-23));
        //7.
        System.out.println(Math.negateExact(-34));
        System.out.println(Math.negateExact(34));
        //8.
        System.out.println(Math.addExact(34, 45));
        //9.
        System.out.println(Math.subtractExact(34, 45));
        //10.
        System.out.println(Math.multiplyExact(34, 45));
        //11.
        System.out.println(Math.pow(2.1, 4));
        //12.
        System.out.println(Math.incrementExact(24));
        //13.
        System.out.println(Math.decrementExact(24));
        //14.
        System.out.println(Math.random());

    }

}
