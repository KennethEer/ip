package duke.task;

/**
 * Represents a deadline task. A <code>Deadline</code> object corresponds to
 * a deadline task with its description, done status and by what deadline.
 */
public class Deadline extends Task {
    protected String byDeadline;

    public Deadline(String description, String byDeadline) {
        super(description);
        this.byDeadline = byDeadline;
    }

    /**
     * Returns deadline task when user prints the deadline task
     *
     * @return description, status icon and by description of deadline task
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + byDeadline + ")";
    }

    public String editFile() {
        return "D | " + super.editFile() + " | " + byDeadline + System.lineSeparator();
    }

}
