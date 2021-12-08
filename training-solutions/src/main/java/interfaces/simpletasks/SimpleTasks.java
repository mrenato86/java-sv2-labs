package interfaces.simpletasks;

import java.util.List;

public class SimpleTasks implements Runnable {

    private List<String> tasks;

    public SimpleTasks(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

    private boolean nextStep() {
        if (tasks == null || tasks.isEmpty()) {
            return false;
        }
        tasks.remove(tasks.size() - 1);
        return !tasks.isEmpty();
    }

    @Override
    public void run() {
        boolean next = true;
        while (next) {
            next = nextStep();
        }

    }
}
