package duke;

public class DukeException extends Exception {
    private static final String ERROR_MESSAGE = "\u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(";
    private static final String EMPTY_TODO = "\u2639" + " OOPS!!! The description of a todo cannot be empty.";
    private static final String EMPTY_EVENT = "\u2639" + " OOPS!!! The description of an event cannot be empty.";
    private static final String EMPTY_DEADLINE = "\u2639" + " OOPS!!! The description of a deadline cannot be empty.";
    private static final String ERROR_DEADLINE = "The deadline task should be written as deadline (name of task) /by (deadline).";
    private static final String ERROR_EVENT = "The event task should be written as event (name of task) /at (time of event).";
    private static final String ERROR_TODO = "The todo task should be written as todo (name of task).";

    protected String taskInput;

    public DukeException(String input) {
        this.taskInput = input;
    }

    void printErrorMessage() {
        System.out.println(Duke.LONG_LINE);
        if (taskInput.equals("todo")) {
            System.out.println(EMPTY_TODO);
        } else if (taskInput.equals("event")) {
            System.out.println(EMPTY_EVENT);
        } else if (taskInput.equals("deadline")) {
            System.out.println(EMPTY_DEADLINE);
        } else if (taskInput.startsWith("deadline")) {
            System.out.println(ERROR_DEADLINE);
        } else if (taskInput.startsWith("event")) {
            System.out.println(ERROR_EVENT);
        } else if (taskInput.startsWith("todo")) {
            System.out.println(ERROR_TODO);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
        System.out.println(Duke.LONG_LINE);
    }
}
