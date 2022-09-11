package singleton;

import java.util.LinkedList;
import java.util.List;

public class StoreTestImpl implements Store {

    private final List<Product> products = new LinkedList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void reset() {
        products.clear();
    }

    @Override
    public int getProductCount() {
        return products.size();
    }

    @Override
    public Product remove() {
        return products.remove(0);
    }
}
