package cmdarguments.operation;

public class Operation {

    public static void main(String[] args) {
        for (String operation : args) {
            if("/list".equals(operation)){
                System.out.println("Listing");
                continue;
            }
            if("/add".equals(operation)){
                System.out.println("Adding");
                continue;
            }
            if("/delete".equals(operation)){
                System.out.println("Deleting");
                continue;
            }
            System.out.println("Unknown Operation");
        }
    }
}
