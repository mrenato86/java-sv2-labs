package classstructureattributes;

public class Client {
    String name, address;
    int year;

    @Override
    public String toString() {
        return  "Name: " + name + ", Address: " + address + ", Born in: " + year;
    }
}
