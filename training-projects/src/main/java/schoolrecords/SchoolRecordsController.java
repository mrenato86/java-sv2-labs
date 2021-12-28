package schoolrecords;

import schoolrecords.entiteswithvalidity.*;
import schoolrecords.outputenums.CommunicationItem;
import schoolrecords.outputenums.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static schoolrecords.outputenums.CommunicationItem.*;

public class SchoolRecordsController {

    private final List<Tutor> tutors = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();
    private final ClassRecords classRecords = new ClassRecords("Fourth Grade A", new Random());

    private void initSchool() {
        subjects.addAll(List.of(
                new Subject("földrajz"),
                new Subject("matematika"),
                new Subject("biológia"),
                new Subject("zene"),
                new Subject("fizika"),
                new Subject("kémia")
        ));
        tutors.add(new Tutor("Nagy Csilla", new ArrayList<>(subjects)));
        Student firstStudent = new Student("Kovács Rita");
        Student secondStudent = new Student("Nagy Béla");
        Student thirdStudent = new Student("Varga Márton");
        firstStudent.grading(new Mark(MarkType.A, subjects.get(0), tutors.get(0)));
        firstStudent.grading(new Mark(MarkType.C, subjects.get(1), tutors.get(0)));
        firstStudent.grading(new Mark(MarkType.D, subjects.get(0), tutors.get(0)));
        secondStudent.grading(new Mark(MarkType.A, subjects.get(2), tutors.get(0)));
        secondStudent.grading(new Mark(MarkType.C, subjects.get(1), tutors.get(0)));
        secondStudent.grading(new Mark(MarkType.D, subjects.get(3), tutors.get(0)));
        thirdStudent.grading(new Mark(MarkType.A, subjects.get(4), tutors.get(0)));
        thirdStudent.grading(new Mark(MarkType.C, subjects.get(5), tutors.get(0)));
        thirdStudent.grading(new Mark(MarkType.D, subjects.get(0), tutors.get(0)));
        classRecords.addStudent(firstStudent);
        classRecords.addStudent(secondStudent);
        classRecords.addStudent(thirdStudent);
    }

    public void runMenu() {
        while (true) {
            printMenu();
            try {
                int selected = getNumberInput(ASK_SELECT);
                System.out.println();
                switch (selected) {
                    case 1:
                        System.out.println("\t" + classRecords.listStudentNames());
                        break;
                    case 2:
                        String parameter = getTextInput(ASK_STUDENT);
                        System.out.println("\t" + classRecords.findStudentByName(parameter));
                        break;
                    case 3:
                        parameter = getTextInput(ASK_STUDENT);
                        System.out.println(classRecords.addStudent(new Student(parameter)) ? TELL_SUCCESS : TELL_FAILURE);
                        break;
                    case 4:
                        parameter = getTextInput(ASK_STUDENT);
                        System.out.println(classRecords.removeStudent(new Student(parameter)) ? TELL_SUCCESS : TELL_FAILURE);
                        break;
                    case 5:
                        repetition();
                        break;
                    case 6:
                        System.out.println("\t" + classRecords.calculateClassAverage());
                        break;
                    case 7:
                        Subject subjectParameter = getSubjectInput();
                        System.out.println("\t" + classRecords.calculateClassAverageBySubject(subjectParameter));
                        break;
                    case 8:
                        listStudyResults();
                        break;
                    case 9:
                        parameter = getTextInput(ASK_STUDENT);
                        System.out.println("\t" + classRecords.findStudentByName(parameter).calculateAverage());
                        break;
                    case 10:
                        Student studentParameter = classRecords.findStudentByName(getTextInput(ASK_STUDENT));
                        System.out.println("\t" + studentParameter.calculateSubjectAverage(getSubjectInput()));
                        break;
                    case 11:
                        System.out.println(TELL_BYE);
                        return;
                    default:
                        System.out.println(TELL_WRONG_MENU);
                }
            } catch (Exception e) {
                System.out.println("\t" + e.getMessage());
            }
            getTextInput(ASK_CONTINUE);
            System.out.println();
        }
    }

    private void printMenu() {
        for (MenuItem item : MenuItem.values()) {
            System.out.println(item);
        }
    }

    private void repetition() {
        Student student = classRecords.repetition();
        System.out.println(TELL_RESULT + student.getName());
        MarkType markType;
        try {
            markType = MarkType.valueOf(getTextInput(ASK_MARK));
        } catch (IllegalArgumentException iae) {
            throw new IllegalStateException(TELL_WRONG_INPUT.toString(), iae);
        }
        Subject subject = getSubjectInput();
        Tutor tutor = getTutorInput();
        if (!tutor.tutorTeachingSubject(subject)) {
            throw new IllegalStateException(TELL_WRONG_INPUT.toString());
        }
        student.grading(new Mark(markType, subject, tutor));
    }

    private void listStudyResults() {
        for (StudyResultByName studyResult : classRecords.listStudyResults()) {
            System.out.println("\t" + studyResult);
        }
    }

    private Subject getSubjectInput() {
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getSubjectName());
        }
        int subject = getNumberInput(ASK_SUBJECT, subjects.size()) - 1;
        return subjects.get(subject);
    }

    private Tutor getTutorInput() {
        for (int i = 0; i < tutors.size(); i++) {
            System.out.println((i + 1) + ". " + tutors.get(i).getName());
        }
        int tutor = getNumberInput(ASK_TUTOR, tutors.size()) - 1;
        return tutors.get(tutor);
    }

    private int getNumberInput(CommunicationItem question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        if (!scanner.hasNextInt()) {
            return -1;
        }
        return scanner.nextInt();
    }

    private int getNumberInput(CommunicationItem question, int end) {
        int result = getNumberInput(question);
        if (result < 0 || result > end) {
            throw new IllegalStateException(TELL_WRONG_INPUT.toString());
        }
        return result;
    }

    private String getTextInput(CommunicationItem question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine().strip();
    }

    public static void main(String[] args) {
        SchoolRecordsController schoolRecordsController = new SchoolRecordsController();
        schoolRecordsController.initSchool();
        schoolRecordsController.runMenu();
    }
}
