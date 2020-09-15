package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[\u2713]" : "[\u2718]"); //return [tick] or [X] symbols
    }
    public String getStatusNumber() {
        return (isDone ? "1" : "0"); //return 1 if done or [0] if undone
    }

    public void doTask() {
        this.isDone = true;
    }

    public String toString() {
        return getStatusIcon() + " " + this.description;
    }
    public String editFile() {
        return getStatusNumber() + " | " + this.description;
    }
}
