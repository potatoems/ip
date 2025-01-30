import java.util.ArrayList;

public class Tasks {
    final private ArrayList<Task> tasks;

    public Tasks() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        Task t = new Task(task);
        tasks.add(t);
        System.out.println("added: " + task);
    }

    public void updateTask(int taskNumber, boolean toBeMarked) {
        Task t = tasks.get(taskNumber - 1);

        if (toBeMarked == !t.getStatus()) {
            boolean isDone = t.updateStatus();
            if (isDone) {
                System.out.println("Nice! I've marked this task as done:\n" + t);
            } else {
                System.out.println("OK, I've marked this task as not done:\n" + t);
            }
        } else {
            System.out.println("It seems like it's already been done");
        }
    }

    public void list() {
        System.out.println("Here are the tasks in your list:");
        tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + ". " + task));
    }
}
