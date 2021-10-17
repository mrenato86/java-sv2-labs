package classstructureintegrate;

import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Owner's Name: ");
        String owner = scanner.nextLine();
        System.out.print("Base Deposit: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        BankAccount newAccount = new BankAccount(accountNumber, owner, amount);
        System.out.println("New account created as: " + newAccount.getInfo() + "\n");

        System.out.print("Amount of new deposit: ");
        newAccount.deposit(scanner.nextInt());
        System.out.println("Successful change on: " + newAccount.getInfo() + "\n");

        System.out.print("Amount to withdraw: ");
        newAccount.withdraw(scanner.nextInt());
        System.out.println("Successful change on: " + newAccount.getInfo() + "\n");
    }

}
