package sorting.webshop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebShop {

    private final List<Product> products;

    public WebShop(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsOrderByName() {
        return getProductsOrderBy(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public List<Product> getProductsOrderByPrice() {
        return getProductsOrderBy(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
    }

    public List<Product> getProductsOrderByDate() {
        return getProductsOrderBy(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getFrom().compareTo(o2.getFrom());
            }
        });
    }

    private List<Product> getProductsOrderBy(Comparator<Product> comparator) {
        List<Product> orderedProducts = new ArrayList<>(products);
        orderedProducts.sort(comparator);
        return orderedProducts;
    }
}
