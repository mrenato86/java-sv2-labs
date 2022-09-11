package singleton;

public interface Store {

    void add(Product product);

    Product remove();

    void reset();

    int getProductCount();
}
