package duke.task;

public class Deadline extends Task {
    protected String byDeadline;

    public Deadline(String description, String byDeadline) {
        super(description);
        this.byDeadline = byDeadline;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + byDeadline + ")";
    }

    public String editFile() {
        return "D | " + super.editFile() + " | " + byDeadline + System.lineSeparator();
    }

    public boolean findInput(String input) {
        if ((super.toString() + byDeadline).contains(input)) {
            return true;
        } else {
            return false;
        }
    }

}
