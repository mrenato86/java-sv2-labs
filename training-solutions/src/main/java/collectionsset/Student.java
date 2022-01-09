package collectionsset;

public class Student implements Comparable<Student> {

    private String name;
    private int height;

    public Student(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Student o) {
        return height - o.height;
    }

    @Override
    public String toString() {
        return name + "(" + height + ")";
    }
}
