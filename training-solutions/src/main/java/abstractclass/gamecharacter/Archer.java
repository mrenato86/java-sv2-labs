package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character {

    private static final int MAX_SECONDARY_DAMAGE = 5;

    private int numberOfArrow;

    public Archer(Point position, Random random) {
        super(position, random);
        this.numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    private int getActualSecondaryDamage() {
        return getRandom().nextInt(1, MAX_SECONDARY_DAMAGE + 1);
    }

    private void shootingAnArrow(Character enemy) {
        if (--numberOfArrow >= 0) {
            hit(enemy, getActualSecondaryDamage());
        }
    }

    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }
}
