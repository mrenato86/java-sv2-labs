package builder.robot;

public class SetMovementCapabilityFrameBuilder {

    private final byte[] bytes = {4, 96, 10, 98, 8, 0};

    public SetMovementCapabilityFrameBuilder setMaximumSpeed(byte speed) {
        bytes[1] = speed;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumRotationSpeed(byte speed) {
        bytes[2] = speed;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumAcceleration(byte acceleration) {
        bytes[3] = acceleration;
        return this;
    }

    public SetMovementCapabilityFrameBuilder setMaximumRotationalAcceleration(byte acceleration) {
        bytes[4] = acceleration;
        return this;
    }

    public Frame build() {
        bytes[5] = checksum();
        return new Frame(bytes);
    }

    private byte checksum() {
        byte checksum = 0;
        for (byte aByte : bytes) {
            checksum += aByte;
        }
        return checksum;
    }
}
