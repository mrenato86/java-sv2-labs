package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Product Price: ");
        int price = scanner.nextInt();

        Product product = new Product(name, price);
        System.out.println("New product: " +product);

        product.increasePrice((int)(product.getPrice()*0.2));
        System.out.println("After 20% price increase: " + product);

        product.decreasePrice((int)(product.getPrice()*0.15));
        System.out.println("After 15% price decrease: " + product);
    }
}
