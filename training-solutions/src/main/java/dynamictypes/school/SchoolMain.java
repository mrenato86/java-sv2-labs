package dynamictypes.school;

public class SchoolMain {

    public static void main(String[] args) {
        School school = new School("School", 12);
        School primary = new PrimarySchool("Primary School", 8);
        School secondary = new SecondarySchool("Secondary School", 4);

        System.out.println(school);
        System.out.println(primary);
        System.out.println(secondary);
    }
}
