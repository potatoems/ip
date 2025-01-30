import java.util.Scanner;

public class Brownie{
    private static final String horizontalLine = "____________________________________________________________";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tasks tasks = new Tasks();

        String greeting = "\nHello! I'm BROWNIE\nWhat can I do for you?\n";
        String farewell = "Bye. Hope to see you again soon!\n";

        System.out.println(horizontalLine + greeting + horizontalLine);

        while(true) {
            String taskDescription = scanner.nextLine();
            if (taskDescription.equalsIgnoreCase("bye")) {
                System.out.println(farewell + horizontalLine);
                break;
            }

            // check for list command. Automatically skip anything that is less than 4 characters
            // skips to next iteration after listing tasks
            if (taskDescription.length() > 3 && taskDescription.substring(0, 4).equalsIgnoreCase("list")) {
                System.out.println(horizontalLine);
                tasks.list();
                System.out.println(horizontalLine);
                continue;
            }

            // mark task in list
            // parses task number as int, parses true if task is to be marked
            if (taskDescription.length() > 4 && taskDescription.substring(0, 4).equalsIgnoreCase("mark")) {
                tasks.updateTask(Integer.parseInt(taskDescription.substring(5)), true);
                System.out.println(horizontalLine);
                continue;
            }

            // unmark task in list
            // parses task number as int, parses false if task is to be unmarked
            if (taskDescription.length() > 6 && taskDescription.substring(0, 6).equalsIgnoreCase("unmark")) {
                tasks.updateTask(Integer.parseInt(taskDescription.substring(7)), false);
                System.out.println(horizontalLine);
                continue;
            }

            // automatically add any task that is listed
            // checks for todos, events and deadlines, initialise to appropriate task type
            System.out.println(horizontalLine);
            if (taskDescription.length() > 4 && taskDescription.substring(0, 4).equalsIgnoreCase("todo")) {
                tasks.add(taskDescription.substring(5), 'T');
            } else if (taskDescription.length() > 5 && taskDescription.substring(0, 5).equalsIgnoreCase("event")) {
                tasks.add(taskDescription.substring(6), 'E');
            } else if (taskDescription.length() > 8 && taskDescription.substring(0, 8).equalsIgnoreCase("deadline")) {
                tasks.add(taskDescription.substring(9), 'D');
            }
            System.out.println(horizontalLine);
        }
    }
}
