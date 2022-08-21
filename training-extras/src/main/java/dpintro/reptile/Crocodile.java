package dpintro.reptile;

public class Crocodile extends LandDweller implements CanSwim {

    public static final int WALK_ENERGY_COST = 20;
    public static final int SWIM_ENERGY_COST = 5;

    public Crocodile(int energy) {
        super(energy);
    }

    @Override
    public void swim() {
        this.decreaseEnergy(SWIM_ENERGY_COST);
    }

    public void walk() {
        this.decreaseEnergy(WALK_ENERGY_COST);
    }
}
