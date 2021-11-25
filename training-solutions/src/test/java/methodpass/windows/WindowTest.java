package methodpass.windows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WindowTest {

    @Test
    void tetCreate() {
        Window window = new Window("room", 120, 150);

        assertEquals("room", window.getRoomName());
        assertEquals(120, window.getWidth());
        assertEquals(150, window.getHeight());
    }

}