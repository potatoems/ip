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
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("bye")) {
                System.out.println(farewell + horizontalLine);
                break;
            }

            // check for list command. Automatically skip anything that is less than 4 characters
            // skips to next iteration after listing tasks
            if (command.length() > 3 && command.substring(0, 4).equalsIgnoreCase("list")) {
                tasks.list();
                System.out.println(horizontalLine);
                continue;
            }

            // automatically add any task that is listed
            System.out.println(horizontalLine);
            tasks.add(command);
            System.out.println(horizontalLine);

        }
    }
}
