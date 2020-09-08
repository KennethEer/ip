import java.util.Scanner;

public class Duke {
    public static final String LONG_LINE = "______________________________________________________________________";
    private static final String GREETING = "Hello! I'm Duke";
    private static final String REQUEST = "What can I do for you?";
    private static final String EXIT = "Bye. Hope to see you again soon!";
    private static final String ADDED_TASK = "Got it. I've added this task:";
    private static int totalTaskNumber = 0;
    private static Task[] tasks = new Task[100];

    public static void printGreeting() {
        System.out.println(LONG_LINE + System.lineSeparator() + GREETING);
        System.out.println(REQUEST + System.lineSeparator() + LONG_LINE);
    }

    public static void addTask(String input) {
        int slashIndex = input.indexOf('/');
        Task currentTask = null;
        try {
            if (input.startsWith("deadline ")) {
                currentTask = createDeadlineTask(input, slashIndex);
            } else if (input.startsWith("event ")) {
                currentTask = createEventTask(input, slashIndex);
            } else if (input.startsWith("todo ")) {
                currentTask = createTodoTask(input);
            } else {
                throw new DukeException(input);
            }
            if (currentTask != null) {
                if (totalTaskNumber < 100) {
                    tasks[totalTaskNumber] = currentTask;
                    totalTaskNumber++;
                }
                System.out.println(LONG_LINE + System.lineSeparator() + ADDED_TASK);
                System.out.println("  " + currentTask);
                String plural = (totalTaskNumber > 1) ? "s" : "";
                System.out.println("Now you have " + totalTaskNumber + " task" + plural + " in the list.");
                System.out.println(LONG_LINE);
            }
        } catch (DukeException e) {
            e.printErrorMessage();
        }

    }

    private static boolean checkValid(String input, int slashIndex) {
        boolean hasAt = input.contains(" /at ");
        boolean hasBy = input.contains(" /by ");
        boolean exceedLength = (slashIndex + 4) >= input.length();
        boolean hasDeadlineTask = (slashIndex - 1) >= 9;
        boolean hasEventTask = (slashIndex - 1) >= 6;

        if (input.contains("deadline")) {
            if (!hasBy || exceedLength || !hasDeadlineTask) {
                return false;
            }
            return true;
        }

        if (input.contains("event")) {
            if (!hasAt || exceedLength || !hasEventTask) {
                return false;
            }
            return true;
        }
        return true;
    }

    private static Task createDeadlineTask(String input, int slashIndex){
        try {
            if (checkValid(input, slashIndex) == false) {

                if (input.trim().equals("deadline")) {
                    throw new DukeException("deadline");
                } else {
                    throw new DukeException(input);
                }
            }
            return new Deadline(input.substring(9, slashIndex - 1), input.substring(slashIndex + 4));
        } catch (DukeException e) {
            e.printErrorMessage();
        }
        return null;
    }

    private static Task createEventTask(String input, int slashIndex) {
        try {
            if (checkValid(input, slashIndex) == false) {
                if (input.trim().equals("event")) {
                    throw new DukeException("event");
                } else {
                    throw new DukeException(input);
                }
            }
            return new Event(input.substring(6, slashIndex - 1), input.substring(slashIndex + 4));
        } catch (DukeException e) {
            e.printErrorMessage();
        }
        return null;

    }

    private static Task createTodoTask(String input) {
        try {
            if (input.substring(5).isBlank()) {
                throw new DukeException("todo");
            } else {
                return new Todo(input.substring(5));
            }
        } catch (DukeException e) {
            e.printErrorMessage();
        }
        return null;
    }

    public static void printExit() {
        System.out.println(LONG_LINE + System.lineSeparator() + EXIT + System.lineSeparator() + LONG_LINE);
    }

    public static void printList() {
        System.out.println(LONG_LINE);
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < totalTaskNumber; i++) {
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
        if (taskNumber > totalTaskNumber || taskNumber <= 0) {
            System.out.println("This task number is invalid. Please try again.");
            return;
        }
        Task taskToFinish = tasks[taskNumber - 1];
        taskToFinish.doTask();
        System.out.println(LONG_LINE);
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskToFinish);
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
            if (in.hasNextLine()) {
                input = in.nextLine();
            }
        }
        printExit();
    }
}
