package duke;

/**
 * Represents the exceptions when the user types in invalid input. A <code>DukeException</code> object
 * corresponds to the error message based on what kind of invalid user input
 */

public class DukeException extends Exception {
    private static final String ERROR_MESSAGE = "\u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(";
    private static final String EMPTY_TODO = "\u2639" + " OOPS!!! The description of a todo cannot be empty.";
    private static final String EMPTY_EVENT = "\u2639" + " OOPS!!! The description of an event cannot be empty.";
    private static final String EMPTY_DEADLINE = "\u2639" + " OOPS!!! The description of a deadline cannot be empty.";
    private static final String ERROR_DEADLINE = "The deadline task should be written as deadline (name of task) /by (deadline).";
    private static final String ERROR_EVENT = "The event task should be written as event (name of task) /at (time of event).";
    private static final String ERROR_TODO = "The todo task should be written as todo (name of task).";
    private static final String ERROR_DELETE = "delete task should be written as delete (task number).";
    private static final String ERROR_DONE = "done task should be written as done (task number).";
    private static final String ERROR_FIND = "find task should be written as find (task description).";

    protected String taskInput;

    public DukeException(String input) {
        this.taskInput = input;
    }

    public String getErrorMessage() {
        String typeOfError;
        if (taskInput.equals("todo")) {
            typeOfError = EMPTY_TODO;
        } else if (taskInput.equals("event")) {
            typeOfError = EMPTY_EVENT;
        } else if (taskInput.equals("deadline")) {
            typeOfError = EMPTY_DEADLINE;
        } else if (taskInput.startsWith("deadline")) {
            typeOfError = ERROR_DEADLINE;
        } else if (taskInput.startsWith("event")) {
            typeOfError = ERROR_EVENT;
        } else if (taskInput.startsWith("todo")) {
            typeOfError = ERROR_TODO;
        } else if (taskInput.startsWith("delete")) {
            typeOfError = ERROR_DELETE;
        } else if (taskInput.startsWith("done")) {
            typeOfError = ERROR_DONE;
        } else if (taskInput.startsWith("find")) {
            typeOfError = ERROR_FIND;
        } else {
            typeOfError = ERROR_MESSAGE;
        }
        return typeOfError;
    }
}
