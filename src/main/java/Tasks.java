import java.util.ArrayList;

public class Tasks {
    private ArrayList<String> tasks;

    public Tasks() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        tasks.add(task);
        System.out.println("added: " + task);
    }

    public void list() {
        tasks.forEach(task -> System.out.println((tasks.indexOf(task) + 1) + ". " + task));
    }
}
