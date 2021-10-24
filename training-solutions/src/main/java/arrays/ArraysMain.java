package arrays;

import java.util.Arrays;

public class ArraysMain {

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    public String multiplicationTableAsString(int size) {
        int[][] multiplicationTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(multiplicationTable);
    }

    public boolean sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay);
    }

    public boolean sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int min = min(day.length, anotherDay.length);
        return Arrays.equals(Arrays.copyOfRange(day, 0, min), Arrays.copyOfRange(anotherDay, 0, min));

    }

    private int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public boolean wonLottery(int[] a, int[] b) {
        int[] copyOfa = Arrays.copyOf(a, a.length);
        int[] copyOfb = Arrays.copyOf(b, b.length);
        Arrays.sort(copyOfa);
        Arrays.sort(copyOfb);

        return Arrays.equals(copyOfa, copyOfb);

    }

    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println("numberOfDaysAsString");
        System.out.println(arraysMain.numberOfDaysAsString());

        System.out.println("multiplicationTableAsString for 5");
        System.out.println(arraysMain.multiplicationTableAsString(5));

        System.out.println("sameTempValues");
        System.out.println(arraysMain.sameTempValues(new double[]{15, 23, 22, 24}, new double[]{15, 23, 22, 24}));
        System.out.println(arraysMain.sameTempValues(new double[]{15, 23, 22, 24}, new double[]{22, 23, 14, 18}));

        System.out.println("sameTempValuesDaylight");
        System.out.println(arraysMain.sameTempValuesDaylight(new double[]{15, 23, 25, 18}, new double[]{15, 23, 25}));
        System.out.println(arraysMain.sameTempValuesDaylight(new double[]{15, 23, 25}, new double[]{21, 23, 11, 18}));

        System.out.println("wonLottery");
        int[] winner = new int[]{14, 42, 33, 24, 76};
        int[] stake = new int[]{76, 42, 24, 33, 14};
        System.out.println(arraysMain.wonLottery(winner, stake));
        System.out.println(Arrays.toString(winner));
        System.out.println(Arrays.toString(stake));
        winner = new int[]{14, 42, 33, 24, 76};
        stake = new int[]{7, 42, 4, 33, 54};
        System.out.println(arraysMain.wonLottery(winner, stake));
    }

}
