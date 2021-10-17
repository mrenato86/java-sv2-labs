package classstructuremethods;

import java.util.Scanner;

public class NoteMain {
    public static void main(String[] args) {
        Note note = new Note();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        note.setName(scanner.nextLine());
        System.out.print("Topic: ");
        note.setTopic(scanner.nextLine());
        System.out.println("Note text: ");
        note.setText(scanner.nextLine());

        System.out.println(note.getNoteText());
    }

}
