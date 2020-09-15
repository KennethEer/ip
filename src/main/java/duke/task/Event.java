package duke.task;

public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    public String editFile() {
        //0 means done, 1 means not done
        return "E | " + super.editFile() + " | " + at + System.lineSeparator();
    }
}
