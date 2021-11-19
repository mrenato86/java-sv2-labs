package introexceptionwritefile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> todos = new ArrayList<>();
        boolean finish = false;
        while (!finish) {
            System.out.println("Next todo (Exit: 'X'):");
            String todo = scanner.nextLine();
            if (todo.equalsIgnoreCase("x")) {
                finish = true;
            } else {
                todos.add(todo);
            }
        }
        Path path = Paths.get("src/main/resources/introexceptionwritefile/todos.txt");
        try {
            Files.write(path, todos);
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing error!", ioe);
        }
    }

}
