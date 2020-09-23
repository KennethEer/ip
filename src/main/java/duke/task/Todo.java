package duke.task;

/**
 * Represents todo task. A <code>Todo</code> object corresponds to
 * a task with its description and done status.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /**
     * Returns todo task when user prints the todo task
     *
     * @return description and status icon of todo task
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String editFile() {
        return "T | " + super.editFile() + System.lineSeparator();
    }

}
