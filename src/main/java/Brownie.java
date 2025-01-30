import java.util.Scanner;

public class Brownie{
    private static final String horizontalLine = "____________________________________________________________\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String greeting = "Hello! I'm BROWNIE\nWhat can I do for you?\n";
        String farewell = "Bye. Hope to see you again soon!\n";

        System.out.println(horizontalLine + greeting + horizontalLine);

        while(true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("bye")) {
                System.out.println(farewell + horizontalLine);
                break;
            }

            echo(command);
        }
    }

    private static void echo(String command) {
        System.out.println(horizontalLine + command + "\n" + horizontalLine);
    }
}
