package introconstructors;

public class TaskMain {

    public static void main(String[] args) {
        Task task = new Task("World Domination", "Destruct world, rebuild own world");
        task.start();
        task.setDuration(340);

        System.out.println("Task: " + task.getTitle());
        System.out.println("Description: " + task.getDescription());
        System.out.println("Start date/time: " + task.getStartDateTime());
        System.out.println("Duration: " + task.getDuration() + " seconds");

    }

}
