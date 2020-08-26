import java.util.Scanner;

public class Duke {
    private static final String LONG_LINE = "____________________________________________________________";
    private static final String GREETING = "Hello! I'm Duke";
    private static final String REQUEST = "What can I do for you?";
    private static final String EXIT = "Bye. Hope to see you again soon!";

    public static void printGreeting() {
        System.out.println(LONG_LINE + System.lineSeparator() + GREETING);
        System.out.println(REQUEST + System.lineSeparator() + LONG_LINE);
    }

    public static void printCommand(String input) {
        System.out.println(LONG_LINE + System.lineSeparator() + input + System.lineSeparator() + LONG_LINE);
    }

    public static void main(String[] args) {
        printGreeting();

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        while (!input.equals("bye")) {
            printCommand(input);
            input = in.nextLine();
        }

        printCommand(EXIT);
    }
}
