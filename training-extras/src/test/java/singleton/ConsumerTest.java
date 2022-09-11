package singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsumerTest {

    @Test
    public void emptyStoreShouldThrowException() throws IllegalStateException {
        Consumer consumer = new Consumer(new StoreTestImpl());

        Exception ex = assertThrows(IllegalStateException.class, consumer::consume);
        assertEquals("Store is empty, no product is available!", ex.getMessage());
    }

    @Test
    public void testConsume() {
        StoreTestImpl store = new StoreTestImpl();
        store.add(new Product("Apple"));
        store.add(new Product("Orange"));

        Consumer consumer = new Consumer(store);

        assertEquals("Apple", consumer.consume().getName());
        assertEquals("Orange", consumer.consume().getName());
    }

}