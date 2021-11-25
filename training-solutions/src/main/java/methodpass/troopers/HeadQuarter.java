package methodpass.troopers;

import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private final List<Trooper> troopers = new ArrayList<>();

    public List<Trooper> getTroopers() {
        return troopers;
    }

    public void addTrooper(Trooper trooper) {
        if (trooper == null) {
            throw new IllegalArgumentException("Trooper cannot be null" );
        }
        troopers.add(trooper);
    }

    public void moveTrooperByName(String name, Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null" );
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty" );
        }
        Trooper trooper = findTrooperByName(name);
        if (trooper != null) {
            moveTrooper(trooper, target);
        }
    }

    public void moveClosestTrooper(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null" );
        }
        Trooper closest = findClosestTrooper(target);
        if (closest != null) {
            moveTrooper(closest, target);
        }

    }

    private Trooper findTrooperByName(String name) {
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        return null;
    }

    private Trooper findClosestTrooper(Position target) {
        if (troopers.isEmpty()) {
            return null;
        }
        Trooper closestTrooper = troopers.get(0);
        double closestDistance = closestTrooper.distanceFrom(target);
        for (Trooper trooper : troopers) {
            double actualDistance = trooper.distanceFrom(target);
            if (actualDistance < closestDistance) {
                closestTrooper = trooper;
                closestDistance = actualDistance;
            }
        }
        return closestTrooper;
    }

    private void moveTrooper(Trooper trooper, Position target) {
        trooper.changePosition(target);
    }
}
