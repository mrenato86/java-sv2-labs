package composition.realestate;

public class RealEstateDotCom {

    public static void main(String[] args) {
        Address address = new Address("Budapest", "1234", "X street", 33);
        System.out.println(address);

        Details details = new Details("Best place ever", address, 200, 30);
        System.out.println(details);

        RealEstate realEstate = new RealEstate("Get the Best Place Ever", 100.9, details);
        System.out.println(realEstate);
    }

}
