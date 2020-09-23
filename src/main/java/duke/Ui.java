package duke;

import duke.task.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static final String LONG_LINE = "______________________________________________________________________";
    private static final String GREETING = "Hello! I'm Duke";
    private static final String REQUEST = "What can I do for you?";
    private static final String EXIT = "Bye. Hope to see you again soon!";
    private static final String ADDED_TASK = "Got it. I've added this task:";

    private Scanner in;

    public void showError(String error) {
        System.out.println(error);
    }

    public void showLoadingError() {
        System.out.println("There is a problem loading the file");
    }

    public void showWelcome() {
        System.out.println(LONG_LINE + System.lineSeparator() + GREETING);
        System.out.println(REQUEST + System.lineSeparator() + LONG_LINE);
    }

    public Ui() {
        in = new Scanner(System.in);
    }

    public String readCommand() {
        return in.nextLine().trim();
    }

    public void showExit() {
        System.out.println(EXIT);
    }

    public void showAddTask(Task currentTask, ArrayList<Task> taskList) {
        System.out.println(ADDED_TASK);
        System.out.println("  " + currentTask);
        String plural = (taskList.size() > 1) ? "s" : "";
        System.out.println("Now you have " + taskList.size() + " task" + plural + " in the list.");
    }

    public void showList(ArrayList<Task> taskList) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i+1 + "." + taskList.get(i));
        }
    }

    public void showCompleteTask(Task taskToFinish) {
        if (taskToFinish != null) {
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(taskToFinish);
        }
    }

    public void showDeleteTask(Task taskToDelete, ArrayList<Task> taskList) {
        if (taskToDelete != null) {
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + taskToDelete);
            String plural = (taskList.size() > 1) ? "s" : "";
            System.out.println("Now you have " + taskList.size() + " task" + plural + " in the list.");
        }
    }

    public void showLine() {
        System.out.println(LONG_LINE);
    }

}
