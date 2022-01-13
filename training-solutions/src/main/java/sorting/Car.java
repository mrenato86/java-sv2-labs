package sorting;

public class Car {

    private String brand;
    private int yearOfProduction;
    private int price;

    public Car(String brand, int yearOfProduction, int price) {
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getPrice() {
        return price;
    }
}
