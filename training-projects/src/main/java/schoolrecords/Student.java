package schoolrecords;

import java.util.List;

public class Student {

    private String name;
    private List<Mark> marks;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark){

    } // érdemjegy rögzítése

    public double calculateAverage(){
        return 0.;
    } // teljes átlag számolása

    public double calculateSubjectAverage(Subject subject){
        return 0.;
    } // tantárgyhoz tartozó átlag számítása

    @Override
    public String toString(){
        return "";
    } // diák szöveges reprezentációja
}
