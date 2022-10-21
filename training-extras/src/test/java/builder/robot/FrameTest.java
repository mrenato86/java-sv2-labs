package builder.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {

    @Test
    public void testCreationAndGetter() {
        byte[] bytes = {-1, 0, 1};
        Frame frame = new Frame(bytes);

        assertEquals(bytes[0], frame.getBytes()[0]);
        assertEquals(bytes[1], frame.getBytes()[1]);
        assertEquals(bytes[2], frame.getBytes()[2]);
    }

    @Test
    public void toHex() {
        byte[] bytes = {-1, 0, 1};
        Frame frame = new Frame(bytes);

        assertEquals("FF-00-01", frame.toHexString());
    }

    @Test
    public void toHexWithEmpty() {
        byte[] bytes = {};
        Frame frame = new Frame(bytes);

        assertEquals("", frame.toHexString());
    }

    @Test
    public void toHexWithOneByte() {
        byte[] bytes = {1};
        Frame frame = new Frame(bytes);

        assertEquals("01", frame.toHexString());
    }
}
