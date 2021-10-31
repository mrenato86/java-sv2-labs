package enumtype.solarsystem;

public enum SolarSystem {

    MERCURY(0), VENUS(0), EARTH(1),
    MARS(2), JUPITER(79), SATURN(62),
    URANUS(27), NEPTUNE(14), PLUTO(5);

    private final int numOfMoons;

    SolarSystem(int numOfMoons) {
        this.numOfMoons = numOfMoons;
    }

    public int getNumOfMoons() {
        return numOfMoons;
    }
}
