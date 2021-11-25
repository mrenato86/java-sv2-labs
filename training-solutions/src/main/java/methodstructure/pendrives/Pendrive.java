package methodstructure.pendrives;

import java.util.Objects;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        price *= 1 + percent / 100.;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pendrive pendrive = (Pendrive) o;
        return capacity == pendrive.capacity && price == pendrive.price && Objects.equals(name, pendrive.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, capacity, price);
    }

    private double getPricePerCapacity() {
        return (double) price / capacity;
    }

    public int comparePricePerCapacity(Pendrive other) {
        return (int) Math.signum(getPricePerCapacity() - other.getPricePerCapacity());
    }

    public boolean isCheaperThan(Pendrive other) {
        return price < other.price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s(%d): %d", name, capacity, price);
    }
}
