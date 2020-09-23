package duke.task;

public class Event extends Task {
    protected String atWhen;

    public Event(String description, String atWhen) {
        super(description);
        this.atWhen = atWhen;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + atWhen + ")";
    }

    public String editFile() {
        return "E | " + super.editFile() + " | " + atWhen + System.lineSeparator();
    }
}
