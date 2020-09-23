package duke;

import duke.task.Task;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a user interface that deals  in the local filesystem. A <code>Storage</code> object corresponds to
 * a filePath where data is stored e.g., <code>taskdata.txt</code>
 */
public class Ui {
    public static final String LONG_LINE = "______________________________________________________________________";
    private static final String GREETING = "Hello! I'm Duke";
    private static final String REQUEST = "What can I do for you?";
    private static final String EXIT = "Bye. Hope to see you again soon!";
    private static final String ADDED_TASK = "Got it. I've added this task:";

    private Scanner in;

    public Ui() {
        in = new Scanner(System.in);
    }

    /**
     * Prints error message based on paramter error
     *
     * @param error  error message
     */
    public void showError(String error) {
        System.out.println(error);
    }

    /**
     * Prints loading error message
     *
     */
    public void showLoadingError() {
        System.out.println("There is a problem loading the file");
    }

    /**
     * Prints welcome message
     *
     */
    public void showWelcome() {
        System.out.println(LONG_LINE + System.lineSeparator() + GREETING);
        System.out.println(REQUEST + System.lineSeparator() + LONG_LINE);
    }

    public String readCommand() {
        return in.nextLine().trim();
    }

    /**
     * Prints goodbye messafe
     *
     */
    public void showExit() {
        System.out.println(EXIT);
    }

    /**
     * Prints message including added task and total number of tasks when user adds a task
     *
     */
    public void showAddTask(Task currentTask, ArrayList<Task> taskList) {
        System.out.println(ADDED_TASK);
        System.out.println("  " + currentTask);
        String plural = (taskList.size() > 1) ? "s" : "";
        System.out.println("Now you have " + taskList.size() + " task" + plural + " in the list.");
    }

    /**
     * Prints the list of tasks when user inputs list command
     *
     */
    public void showList(ArrayList<Task> taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i+1 + "." + taskList.get(i));
        }
    }

    /**
     * Prints the message about the task that was done when user inputs done command
     *
     */
    public void showCompleteTask(Task taskToFinish) {
        if (taskToFinish != null) {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskToFinish);
        }
    }

    /**
     * Prints the message about the task that was deleted when user inputs delete command
     *
     */
    public void showDeleteTask(Task taskToDelete, ArrayList<Task> taskList) {
        if (taskToDelete != null) {
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + taskToDelete);
            String plural = (taskList.size() > 1) ? "s" : "";
            System.out.println("Now you have " + taskList.size() + " task" + plural + " in the list.");
        }
    }
    /**
     * Prints line
     *
     */
    public void showLine() {
        System.out.println(LONG_LINE);
    }

}
