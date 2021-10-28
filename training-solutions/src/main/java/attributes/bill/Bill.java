package attributes.bill;

public class Bill {

    public static void main(String[] args) {
        BillItem milk = new BillItem("milk", 270, 3, 18.0);
        BillItem bread = new BillItem("bread", 400, 1, 18.0);
        BillItem cocoa = new BillItem("cocoa", 950, 2, 27.0);

        System.out.println(milk.getProduct());
        System.out.println(milk.getPrice());
        System.out.println(milk.getQuantity());
        System.out.println(milk.getVatPercent());

        double totalPrice = milk.calculateTotalPrice() + bread.calculateTotalPrice() + cocoa.calculateTotalPrice();

        System.out.println(totalPrice);
    }

}
