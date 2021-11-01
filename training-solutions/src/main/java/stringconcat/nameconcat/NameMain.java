package stringconcat.nameconcat;

public class NameMain {

    public static void main(String[] args) {
        Name firstName = new Name("Balmer", "Gerald", "Thomas", Title.MR);
        Name secondName = new Name("Balmer", "Thomas", Title.DR);
        Name thirdName = new Name("Balmer", null, "Thomas", null);
        Name fourthName = new Name("Balmer", "Thomas");

        System.out.println(firstName.concatNameWesternStyle());
        System.out.println(firstName.concatNameHungarianStyle() + "\n");

        System.out.println(secondName.concatNameWesternStyle());
        System.out.println(secondName.concatNameHungarianStyle() + "\n");

        System.out.println(thirdName.concatNameWesternStyle());
        System.out.println(thirdName.concatNameHungarianStyle() + "\n");

        System.out.println(fourthName.concatNameWesternStyle());
        System.out.println(fourthName.concatNameHungarianStyle());
    }

}
