package introcontrol;

public class IntroControl {

    //1.
    public int subtractTenIfGreaterThanTen(int number){
        if (number <= 10){
            return number;
        } else {
            return number - 10;
        }
    }
    //2.
    public String describeNumber(int number){
        if (number == 0){
            return "zero";
        } else {
            return "not zero";
        }
    }
    //3.
    public String greetingToJoe(String name){
        if ("Joe".equals(name)){
            return "Hello Joe";
        } else {
            return "";
        }
    }
    //4.
    public int calculateBonus(int sale){
        if (sale >= 1000000){
            return sale / 10;
        } else {
            return 0;
        }
    }
    //5.
    public int calculateConsumption(int prev, int next){
        if (prev <= next) {
            return next - prev;
        } else {
            return 10000 - prev + next;
        }
    }
    //6.
    public void printNumbers(int max){
        for (int i = 0; i <= max; i++) {
            System.out.println(i);
        }
    }
    //7.
    public void printNumbersBetween(int min, int max){
        for (int i = min; i <= max ; i++) {
            System.out.println(i);
        }
    }
    //8.
    public void printNumbersBetweenAnyDirection(int a, int b){
        if (b > a) {
            printNumbersBetween(a,b);
        } else {
            for (int i = a; i >= b; i--) {
                System.out.println(i);
            }
        }
    }
    //9.
    public void printOddNumbers(int max){
        for (int i = 1; i <= max ; i+=2) {
            System.out.println(i);
        }
    }

}
