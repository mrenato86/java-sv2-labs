package introexceptionthrowjunit5;

public class Tank {

    private int angle;

    public void modifyAngle(int angleNumber) {
        angle += angleNumber;
        angle %= 360;
        if (angle < 0) {
            angle += 360;
        }

        if (angle > 80 && angle < 280) {
            throw new IllegalArgumentException("Turret can't be in a position between 80° and 280°!");
        }
    }

    public int getAngle() {
        return angle;
    }

}
