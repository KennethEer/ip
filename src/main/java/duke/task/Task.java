package duke.task;

/**
 * Represents a task. A <code>Task</code> object corresponds to
 * a task with its description and done status
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected static final String tick = "[\u2713]";
    protected static final String cross = "[\u2718]";

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns status icon to show if task is done.
     *
     * @return status icon.
     */
    public String getStatusIcon() {
        return (isDone ? tick : cross); //return [tick] or [X] symbols
    }

    /**
     * Returns status number to show if task is done.
     *
     * @return status number.
     */
    public String getStatusNumber() {
        return (isDone ? "1" : "0"); //return 1 if done or 0 if undone
    }

    /**
     * Modify status from undone to done to show that task is done.
     *
     */
    public void doTask() {
        this.isDone = true;
    }

    /**
     * Returns task when user prints the task
     *
     * @return description of task and status icon of task
     */
    public String toString() {
        return getStatusIcon() + " " + this.description;
    }

    public String editFile() {
        return getStatusNumber() + " | " + this.description;
    }

    public boolean findInput(String input) {
        if (toString().contains(input)) {
            return true;
        } else {
            return false;
        }
    }
}


