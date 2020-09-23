package duke.task;

/**
 * Represents an event task. A <code>Event</code> object corresponds to
 * an event task with its description, done status and at when.
 */
public class Event extends Task {
    protected String atWhen;

    public Event(String description, String atWhen) {
        super(description);
        this.atWhen = atWhen;
    }
    /**
     * Returns an event task when user prints the event task
     *
     * @return description, status icon and at when description of event task
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + atWhen + ")";
    }

    public String editFile() {
        return "E | " + super.editFile() + " | " + atWhen + System.lineSeparator();
    }
}
