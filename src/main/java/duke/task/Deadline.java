package duke.task;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String editFile() {
        //0 means done, 1 means not done
        return "D | " + super.editFile() + " | " + by + System.lineSeparator();
    }

}
