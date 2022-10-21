package builder.robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SetMovementCapabilityFrameBuilderTest {

    @Test
    public void testBuildWDefaultValues() {
        Frame frame = new SetMovementCapabilityFrameBuilder().build();

        assertEquals("04-60-0A-62-08-D8", frame.toHexString());
    }

    @Test
    public void testBuildUsingOnlyAcceleration() {
        Frame frame = new SetMovementCapabilityFrameBuilder().setMaximumAcceleration((byte) 100).build();

        assertEquals("04-60-0A-64-08-DA", frame.toHexString());
    }

    @Test
    public void testBuildSetAll() {
        Frame frame = new SetMovementCapabilityFrameBuilder()
                .setMaximumAcceleration((byte) 0)
                .setMaximumRotationalAcceleration((byte) 0)
                .setMaximumSpeed((byte) 0)
                .setMaximumRotationSpeed((byte) 0)
                .build();

        assertEquals("04-00-00-00-00-04", frame.toHexString());
    }

}