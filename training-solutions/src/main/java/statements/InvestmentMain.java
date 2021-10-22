package statements;

import java.util.Scanner;

public class InvestmentMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fund: ");
        int fund = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Interest Rate: ");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(fund,interestRate);
        System.out.println("\n" + "Fund of investment: " + investment.getFund());
        System.out.println("Yield after 50 days: " + investment.getYield(50));
        System.out.println("Payment after 80 days: " + investment.close(80));
        System.out.println("Payment after 90 days: " + investment.close(90));

    }

}
