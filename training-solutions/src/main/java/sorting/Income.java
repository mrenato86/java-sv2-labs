package sorting;

import java.util.Arrays;

public class Income {

    private int[] incomes;
    private boolean sorted;

    public Income(int[] incomes) {
        this.incomes = incomes;
    }

    public int[] getIncomes() {
        return Arrays.copyOf(incomes, incomes.length);
    }

    public int getHighestIncome() {
        if (!sorted) {
            Arrays.sort(incomes);
        }
        return incomes[incomes.length - 1];
    }

}
