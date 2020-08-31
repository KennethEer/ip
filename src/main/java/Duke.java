import java.util.Scanner;

public class Duke {
    private static final String LONG_LINE = "____________________________________________________________";
    private static final String GREETING = "Hello! I'm Duke";
    private static final String REQUEST = "What can I do for you?";
    private static final String EXIT = "Bye. Hope to see you again soon!";
    private static int totalTaskNumber = 0;
    private static Task[] tasks = new Task[100];

    public static void printGreeting() {
        System.out.println(LONG_LINE + System.lineSeparator() + GREETING);
        System.out.println(REQUEST + System.lineSeparator() + LONG_LINE);
    }

    /*public static void addTask(String input) {
        Task currentTask = new Task(input);
        tasks[totalTaskNumber] = currentTask;
        totalTaskNumber++;
        System.out.println(LONG_LINE + System.lineSeparator() + "added: " + input + System.lineSeparator() + LONG_LINE);
    }*/

    public static void addTask(String input) {
        int slashIndex = input.indexOf('/');
        Task currentTask;
        if (input.startsWith("deadline ")) {
            currentTask = new Deadline(input.substring(9, slashIndex - 1), input.substring(slashIndex + 4));
        }
        else if (input.startsWith("event ")) {
            currentTask = new Event(input.substring(6, slashIndex - 1), input.substring(slashIndex + 4));
        }
        else if (input.startsWith("todo ")){
            currentTask = new Todo(input.substring(5));
        }
        else {
            //Treat all other tasks as Todo tasks
            currentTask = new Todo(input);
        }

        tasks[totalTaskNumber] = currentTask;
        totalTaskNumber++;
        System.out.println(LONG_LINE + System.lineSeparator() + "Got it. I've added this task: ");
        System.out.println("  " + currentTask);
        String plural = (totalTaskNumber > 1) ? "s" : "";
        System.out.println("Now you have " + totalTaskNumber + " task" + plural + " in the list.");
        System.out.println(LONG_LINE);
    }


    public static void printExit() {
        System.out.println(LONG_LINE + System.lineSeparator() + EXIT + System.lineSeparator() + LONG_LINE);
    }

    public static void printList() {
        System.out.println(LONG_LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < totalTaskNumber; i++) {
            //System.out.println(i+1 + "." + tasks[i].getStatusIcon() + " " + tasks[i].description);
            System.out.println(i+1 + "." + tasks[i]);

        }
        System.out.println(LONG_LINE);
    }

    public static void completeTask(String input) {
        if (input.length() <= 5) {
            return;
        }
        String taskDigit = input.substring(5);
        int taskNumber = Integer.parseInt(taskDigit);
        if (taskNumber > totalTaskNumber) {
            return;
        }
        Task taskToFinish = tasks[taskNumber - 1];
        taskToFinish.doTask();
        System.out.println(LONG_LINE);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskToFinish.getStatusIcon() + " " + taskToFinish.description);
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
            } else if (input.contains("done")) {
                completeTask(input);
            } else {
                addTask(input);
            }
            input = in.nextLine();
        }
        printExit();
    }
}
