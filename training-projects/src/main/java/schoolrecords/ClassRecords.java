package schoolrecords;

import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random random;
    private List<Student> students;

    public ClassRecords(String className, Random random) {
        this.className = className;
        this.random = random;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student){
      return false;
    } // felvesz egy diákot az osztályba

    public boolean removeStudent(Student student){
        return false;
    } //kivesz egy diákot az osztályból

    public double calculateClassAverage(){
        return 0.;
    } //osztályátlagot számol, minden diákot figyelembe véve

    public double calculateClassAverageBySubject(Subject subject){
        return 0.;
    } //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye

    public Student findStudentByName(String name){
        return null;
    } // név szerint megkeres egy diákot az osztályban

    public Student repetition(){
        return null;
    } //felelethez a listából random módon kiválaszt egy diákot

    public List<StudyResultByName> listStudyResults(){
        return null;
    } //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza

    public String listStudentNames(){
        return "";
    } //kilistázza a diákok neveit, vesszővel elválasztva

}
