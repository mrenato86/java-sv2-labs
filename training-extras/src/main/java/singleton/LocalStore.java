package singleton;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LocalStore implements Store {

    public static final int CAPACITY = 3000;
    private static LocalStore instance;
    private final List<Product> products;

    private LocalStore() {
        this.products = Collections.synchronizedList(new LinkedList<>());
    }

    public static LocalStore getInstance() {
        if (instance == null) {
            instance = new LocalStore();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        if (products.size() < CAPACITY) {
            products.add(product);
        }
    }

    @Override
    public Product remove() {
        if (products.isEmpty()) {
            throw new IllegalStateException("Store is empty, no product is available!");
        }
        return products.remove(0);
    }

    @Override
    public void reset() {
        products.clear();
    }

    @Override
    public int getProductCount() {
        return products.size();
    }
}
