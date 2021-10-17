package classstructureconstructors;

public class StoreMain {

    public static void main(String[] args) {

        Store firstStore = new Store("Phone");
        Store secondStore = new Store("Tablet");

        firstStore.store(200);
        secondStore.store(300);
        System.out.println("Before Dispatch:");
        System.out.println("There are " + firstStore.getStock() + " " + firstStore.getProduct() + "s in stock.");
        System.out.println("There are " + secondStore.getStock() + " " + secondStore.getProduct() + "s in stock.");

        firstStore.dispatch(40);
        secondStore.dispatch(30);

        System.out.println("After Dispatch:");
        System.out.println("There are " + firstStore.getStock() + " " + firstStore.getProduct() + "s in stock.");
        System.out.println("There are " + secondStore.getStock() + " " + secondStore.getProduct() + "s in stock.");

    }

}
