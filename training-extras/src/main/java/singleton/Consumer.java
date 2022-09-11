package singleton;

public class Consumer {

    private final Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public Product consume() {
        if (store.getProductCount() == 0) {
            throw new IllegalStateException("Store is empty, no product is available!");
        }
        return store.remove();
    }
}
