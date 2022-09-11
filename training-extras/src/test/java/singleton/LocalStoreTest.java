package singleton;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocalStoreTest {

    @Test
    public void testGetInstance() {
        LocalStore store = LocalStore.getInstance();
        LocalStore localStore = LocalStore.getInstance();

        assertEquals(localStore, store);
    }

    @Test
    public void testAdd() {
        LocalStore store = LocalStore.getInstance();
        assertEquals(0, store.getProductCount());

        store.add(new Product("Apple"));
        assertEquals(1, store.getProductCount());
    }

    @Test
    public void testAddTooMuch() {
        LocalStore store = LocalStore.getInstance();
        store.reset();
        assertEquals(0, store.getProductCount());

        IntStream.rangeClosed(0, LocalStore.CAPACITY)
                .forEach(i -> store.add(new Product("Apple")));

        assertEquals(LocalStore.CAPACITY, store.getProductCount());
    }

    @Test
    public void removeFromEmptyStoreShouldThrowException() throws IllegalStateException {
        LocalStore store = LocalStore.getInstance();
        store.reset();

        Exception ex = assertThrows(IllegalStateException.class, store::remove);
        assertEquals("Store is empty, no product is available!", ex.getMessage());
    }

    @Test
    public void testAddRemove() {
        LocalStore store = LocalStore.getInstance();
        store.reset();

        assertEquals(0, store.getProductCount());

        store.add(new Product("Apple"));
        assertEquals(1, store.getProductCount());

        store.remove();
        assertEquals(0, store.getProductCount());
    }

}