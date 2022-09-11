package singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProducerTest {

    @Test
    public void testProduce() {
        StoreTestImpl store = new StoreTestImpl();
        Producer producer = new Producer(store);

        Product product = producer.produce("Apple");

        assertEquals(product.getName(), store.remove().getName());
    }

}