package methodpass.windows;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WindowOperationTest {

    @Test
    void testRiseSize() {
        List<Window> windows = List.of(
                new Window("room1", 110, 150),
                new Window("room2", 90, 150),
                new Window("room3", 90, 150),
                new Window("room4", 70, 100)
        );

        WindowOperation windowOperation = new WindowOperation();
        windowOperation.riseSize(windows, 30);

        assertEquals(180, windows.get(1).getHeight());
        assertEquals(130, windows.get(3).getHeight());
    }
}