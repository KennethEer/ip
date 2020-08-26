import java.util.Scanner;

public class Duke {
    private static final String LONG_LINE = "____________________________________________________________";
    private static final String GREETING = "Hello! I'm Duke";
    private static final String REQUEST = "What can I do for you?";
    private static final String EXIT = "Bye. Hope to see you again soon!";
    private static int taskNumber = 0;
    private static String[] tasks = new String[100];

    public static void printGreeting() {
        System.out.println(LONG_LINE + System.lineSeparator() + GREETING);
        System.out.println(REQUEST + System.lineSeparator() + LONG_LINE);
    }

    public static void printCommand(String input) {
        tasks[taskNumber] = input;
        taskNumber++;
        System.out.println(LONG_LINE + System.lineSeparator() + "added: " + input + System.lineSeparator() + LONG_LINE);
    }

    public static void printExit() {
        System.out.println(LONG_LINE + System.lineSeparator() + EXIT + System.lineSeparator() + LONG_LINE);
    }

    public static void printList() {
        System.out.println(LONG_LINE);
        for (int i = 0; i < taskNumber; i++) {
            System.out.println(i+1 + ". " + tasks[i]);
        }
        System.out.println(LONG_LINE);
    }

    public static void main(String[] args) {
        printGreeting();

        String input;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                printList();
            } else {
                printCommand(input);
            }
            input = in.nextLine();
        }

        printExit();
    }
}
