package builder.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MoveFrameBuilderTest {

    @Test
    public void testBuildOnlyOneRotation() {
        MoveFrameBuilder moveFrameBuilder = new MoveFrameBuilder();
        Frame frame = moveFrameBuilder.setRotationSpeed((byte) 100).build();

        assertEquals("7D-00-00-64-00-E1", frame.toHexString());
    }

    @Test
    public void testBuildSettingAllValue() {
        MoveFrameBuilder moveFrameBuilder = new MoveFrameBuilder();
        Frame frame = moveFrameBuilder
                .setXSpeed((byte) 1)
                .setYSpeed((byte) 2)
                .setRotationSpeed((byte) 3)
                .setMaximumSpeed((byte) 4)
                .build();

        assertEquals("7D-01-02-03-04-87", frame.toHexString());
    }

    @Test
    public void testBuildDefaultValues() {
        Frame frame = new MoveFrameBuilder().build();

        assertEquals("7D-00-00-00-00-7D", frame.toHexString());
    }

}