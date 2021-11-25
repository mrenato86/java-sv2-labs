package methodpass.troopers;

public class Trooper {

    private String name;
    private Position position;

    public Trooper(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name cannot be empty" );
        }
        this.name = name;
        this.position = new Position(0, 0);
    }

    private boolean isEmpty(String name) {
        return (name == null || name.isBlank());
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void changePosition(Position target) {
        if (target == null) {
            throw new IllegalArgumentException("The new position cannot be null" );
        }
        position = target;

    }

    public double distanceFrom(Position target) {
        return position.distanceFrom(target);
    }

}
